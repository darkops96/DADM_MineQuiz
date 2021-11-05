package com.example.dadm_prac1;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

        holder.btEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                UserData data = dataList.get(holder.getAdapterPosition());
                String sUsername = data.getUsername();

                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.dialog_update);
                int width = WindowManager.LayoutParams.MATCH_PARENT;
                int height = WindowManager.LayoutParams.WRAP_CONTENT;
                dialog.getWindow().setLayout(width, height);
                dialog.show();

                EditText editText = dialog.findViewById(R.id.edit_text);
                Button btUpdate = dialog.findViewById(R.id.bt_update);

                editText.setText(sUsername);

                btUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.dismiss();
                    }
                });
            }
        });

        holder.btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData data = dataList.get(holder.getAdapterPosition());

                database.mainDao().delete(data);

                //Notificamos la eliminacion
                int position = holder.getAdapterPosition();
                dataList.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, dataList.size());

            }
        });

        holder.btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserData data = dataList.get(holder.getAdapterPosition());
                OpenMenu(data.getUsername().trim());
            }
        });
    }

    public void OpenMenu(String username){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("User", username);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView btEdit, btDelete, btPlay;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_view);
            btEdit = itemView.findViewById(R.id.bt_edit);
            btDelete = itemView.findViewById(R.id.bt_delete);
            btPlay = itemView.findViewById(R.id.bt_play);
        }
    }
}
