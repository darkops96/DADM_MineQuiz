package com.example.dadm_prac1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {QuestionsData.class}, version = 1, exportSchema = false)
public abstract class RoomQuestionsDB extends RoomDatabase {
    //Create database instance
    private static RoomQuestionsDB database;
    //Define database name
    private static String DATABASE_NAME = "questions";

    public synchronized static RoomQuestionsDB getInstance(Context context){
        //Miramos si ya existe
        if(database == null){
            //Inicializamos la base de datos
            database = Room.databaseBuilder(context.getApplicationContext(), RoomQuestionsDB.class, DATABASE_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();

            //AQUI AÑADIRIAMOS LAS PREGUNTAS PARA LA BD DE PREGUNTAS
            QuestionsData question = new QuestionsData();
            question.setQuestion("¿Qué hace el Creeper?");
            question.setAnswer1("Explotar");
            question.setAnswer2("Curar");
            question.setAnswer3("Hacer Intercambios");
            question.setAnswer4("Teletransportarse");
            question.setCorrectAnswers(1000);
            question.setType(0);
            database.questionsDao().insert(question);
            question.setQuestion("¿Cuándo se creó Minecraft?");
            question.setAnswer1("2007");
            question.setAnswer2("2008");
            question.setAnswer3("2009");
            question.setAnswer4("2010");
            question.setCorrectAnswers(0010);
            question.setType(0);
            database.questionsDao().insert(question);
            question.setQuestion("¿Qué se hace con \neste bloque?");
            question.setAnswer1("Valla de piedra");
            question.setAnswer2("Barco");
            question.setAnswer3("Libro");
            question.setAnswer4("Casco de cuero");
            question.setCorrectAnswers(0100);
            question.setType(0);
            database.questionsDao().insert(question);
            question.setQuestion("¿Cómo se conoce al\ncreador del juego?");
            question.setAnswer1("Notch");
            question.setAnswer2("Miguel");
            question.setAnswer3("Marcos Gomez");
            question.setAnswer4("Steve");
            question.setCorrectAnswers(1000);
            question.setType(0);
            database.questionsDao().insert(question);
            question.setQuestion("¿Cuál de estás habilidades \nno tiene ningún mob?");
            question.setAnswer1("Volar");
            question.setAnswer2("Usar el arco");
            question.setAnswer3("Hacerte levitar");
            question.setAnswer4("Planear");
            question.setCorrectAnswers(0001);
            question.setType(0);
            database.questionsDao().insert(question);
            question.setQuestion("¿Cómo puedes saber la vida \nque tiene tu lobo sin usar ningún mod?");
            question.setAnswer1("Viendo sus orejas");
            question.setAnswer2("No se puede");
            question.setAnswer3("Viendo su cola");
            question.setAnswer4("Por el color del pelaje");
            question.setCorrectAnswers(0010);
            question.setType(0);
            database.questionsDao().insert(question);

            //Preguntas con respuesta con imagen:
            question.setQuestion("¿Qué criaturas fueron\n eliminadas en 2021?");
            question.setAnswer1(Integer.toString(R.drawable.allay));
            question.setAnswer2(Integer.toString(R.drawable.glare));
            question.setAnswer3(Integer.toString(R.drawable.golemcobre));
            question.setAnswer4("");
            question.setCorrectAnswers(0110);
            question.setType(1);
            database.questionsDao().insert(question);
            question.setQuestion("¿Qué picos pueden picar\n la bedrock?");
            question.setAnswer1(Integer.toString(R.drawable.picomadera));
            question.setAnswer2(Integer.toString(R.drawable.picodiamante));
            question.setAnswer3(Integer.toString(R.drawable.picohierro));
            question.setAnswer4("");
            question.setCorrectAnswers(0000);
            question.setType(1);
            database.questionsDao().insert(question);
            question.setQuestion("¿En qué bloque crece\n la caña de azucar?");
            question.setAnswer1(Integer.toString(R.drawable.sand));
            question.setAnswer2(Integer.toString(R.drawable.soulsand));
            question.setAnswer3(Integer.toString(R.drawable.grass));
            question.setAnswer4("");
            question.setCorrectAnswers(1000);
            question.setType(1);
            database.questionsDao().insert(question);
            question.setQuestion("¿Con qué se puede\ncurar a un lobo\nen Minecraft Vanilla?");
            question.setAnswer1(Integer.toString(R.drawable.ternera));
            question.setAnswer2(Integer.toString(R.drawable.pezglobo));
            question.setAnswer3(Integer.toString(R.drawable.cerdo));
            question.setAnswer4("");
            question.setCorrectAnswers(1010);
            question.setType(1);
            database.questionsDao().insert(question);

            //Preguntas multimedia:
            question.setQuestion("¿A qué mob corresponde este sonido?");
            question.setAnswer1("Lobo");
            question.setAnswer2("Aldeano");
            question.setAnswer3("Creeper");
            question.setAnswer4("Zombie");
            question.setCorrectAnswers(0010);
            question.setType(2);
            database.questionsDao().insert(question);
            question.setQuestion("¿A qué mob corresponde este sonido?");
            question.setAnswer1("Esqueleto");
            question.setAnswer2("Calamar");
            question.setAnswer3("Creeper");
            question.setAnswer4("Lobo");
            question.setCorrectAnswers(0001);
            question.setType(2);
            database.questionsDao().insert(question);
            question.setQuestion("¿A qué mob corresponde este sonido?");
            question.setAnswer1("Enderman");
            question.setAnswer2("Cerdo");
            question.setAnswer3("Oveja");
            question.setAnswer4("Zombie");
            question.setCorrectAnswers(0100);
            question.setType(2);
            database.questionsDao().insert(question);
            question.setQuestion("¿A qué mob corresponde este sonido?");
            question.setAnswer1("Lobo");
            question.setAnswer2("Aldeano");
            question.setAnswer3("Creeper");
            question.setAnswer4("Zombie");
            question.setCorrectAnswers(0001);
            question.setType(2);
            database.questionsDao().insert(question);
            question.setQuestion("¿A qué objeto corresponde este sonido?");
            question.setAnswer1("Arco");
            question.setAnswer2("Cubo de agua");
            question.setAnswer3("Piston");
            question.setAnswer4("Placa de presión");
            question.setCorrectAnswers(0100);
            question.setType(2);
            question.setQuestion("¿A qué objeto corresponde este sonido?");
            question.setAnswer1("Arco");
            question.setAnswer2("Cubo de agua");
            question.setAnswer3("Piston");
            question.setAnswer4("Placa de presión");
            question.setCorrectAnswers(0001);
            question.setType(2);
            question.setQuestion("¿A qué objeto corresponde este sonido?");
            question.setAnswer1("Arco");
            question.setAnswer2("Cubo de agua");
            question.setAnswer3("Piston");
            question.setAnswer4("Placa de presión");
            question.setCorrectAnswers(1000);
            question.setType(2);
            question.setQuestion("¿A qué objeto corresponde este sonido?");
            question.setAnswer1("Arco");
            question.setAnswer2("Cubo de agua");
            question.setAnswer3("Piston");
            question.setAnswer4("Placa de presión");
            question.setCorrectAnswers(0010);
            question.setType(2);
            question.setQuestion("¿A qué disco pertenece este sonido?");
            question.setAnswer1("Cat");
            question.setAnswer2("Blocks");
            question.setAnswer3("13");
            question.setAnswer4("11");
            question.setCorrectAnswers(0001);
            question.setType(2);
            question.setQuestion("¿A qué disco pertenece este sonido?");
            question.setAnswer1("Cat");
            question.setAnswer2("Blocks");
            question.setAnswer3("13");
            question.setAnswer4("11");
            question.setCorrectAnswers(1000);
            question.setType(2);

        }

        return database;
    }

    //Create Dao
    public abstract QuestionsDao questionsDao();

}
