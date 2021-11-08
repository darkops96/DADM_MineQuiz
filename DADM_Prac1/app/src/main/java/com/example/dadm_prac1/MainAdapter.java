package com.example.dadm_prac1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private List<UserData> dataList;
    private Activity context;
    private RoomUsersDB database;

    public MainAdapter(Activity context, List<UserData> dataList){
        this.context = context;
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inicializar view
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Recogemos los datos
        UserData mainData = dataList.get(position);

        //Inicializamos la base de datos
        database = RoomUsersDB.getInstance(context);

        //Seteamos el texto en el textview
        holder.textView.setText(mainData.getUsername());
        Bitmap bitmap;
        if(mainData.getUserPhoto().equalsIgnoreCase("minecraft_steve")){
            bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.minecraft_steve);

            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            float scaleWidth = ((float) 3456) / width;
            float scaleHeight = ((float) 4608) / height;
            // CREATE A MATRIX FOR THE MANIPULATION
            Matrix matrix = new Matrix();
            // RESIZE THE BIT MAP
            matrix.postScale(scaleWidth, scaleHeight);

            // "RECREATE" THE NEW BITMAP
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        }
        else {
            bitmap = BitmapFactory.decodeFile(mainData.getUserPhoto());
        }
        holder.photoUser.setImageBitmap(bitmap);

        holder.numGames.setText("Partidas: "+mainData.getTimesPlayed());
        holder.maxPoint.setText(mainData.getPoints() + " puntos");
        holder.lastTime.setText(mainData.getLastTime());

        holder.btEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                UserData data = dataList.get(holder.getAdapterPosition());

                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_update);
                int width = WindowManager.LayoutParams.MATCH_PARENT;
                int height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.getWindow().setLayout(width, height);


                ImageButton btUpdate = dialog.findViewById(R.id.bt_update);

                Bitmap bitmap;
                if(mainData.getUserPhoto().equalsIgnoreCase("minecraft_steve")) {
                    bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.minecraft_steve);
                } else {
                    bitmap = BitmapFactory.decodeFile(data.getUserPhoto());
                }
                int w = bitmap.getWidth();
                int h = bitmap.getHeight();
                float scaleWidth = ((float) 576) / w;
                float scaleHeight = ((float) 768) / h;
                Matrix matrix = new Matrix();
                matrix.postScale(scaleWidth, scaleHeight);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, false);
                btUpdate.setImageBitmap(bitmap);

                dialog.show();

                btUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(context, ActivityUpdatePhoto.class);
                        intent.putExtra("user", data.getUsername());
                        intent.putExtra("oldPhoto", data.getUserPhoto());
                        context.startActivity(intent);
                        dialog.dismiss();
                        context.finish();
                    }
                });
            }
        });

        holder.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UserData data = dataList.get(holder.getAdapterPosition());

                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_delete);
                int width = WindowManager.LayoutParams.MATCH_PARENT;
                int height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.getWindow().setLayout(width, height);
                Button btSi = (Button) dialog.findViewById(R.id.bt_si);
                Button btNo = (Button) dialog.findViewById(R.id.bt_no);
                dialog.show();

                btSi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        database.mainDao().delete(data);
                        //Notificamos la eliminacion
                        int position = holder.getAdapterPosition();
                        dataList.remove(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, dataList.size());
                        dialog.dismiss();
                    }
                });

                btNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });

        holder.btPlay.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                UserData data = dataList.get(holder.getAdapterPosition());
                ZoneId spain = ZoneId.of("Europe/Paris");
                ZonedDateTime zdt = Instant.now().atZone(spain);
                database.mainDao().updateDate(data.getUsername(), zdt.toLocalDate().toString());
                dataList.clear();
                dataList.addAll(database.mainDao().getAll());
                notifyDataSetChanged();
                OpenMenu(data.getUsername().trim());
            }
        });
    }

    public void OpenMenu(String username){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("User", username);
        intent.putExtra("Gamemode", database.mainDao().getQuizType(username));
        intent.putExtra("numPregs", database.mainDao().getNumPregs(username));
        context.startActivity(intent);
        context.finish();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView, lastTime, maxPoint, numGames;
        ImageView photoUser;
        ImageView btEdit, btDelete, btPlay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_view);
            lastTime = itemView.findViewById(R.id.fechaPart);
            maxPoint = itemView.findViewById(R.id.maxPunt);
            numGames = itemView.findViewById(R.id.numPart);
            btEdit = itemView.findViewById(R.id.bt_edit);
            btDelete = itemView.findViewById(R.id.bt_delete);
            btPlay = itemView.findViewById(R.id.bt_play);
            photoUser = itemView.findViewById(R.id.user_photo);
        }
    }
}
