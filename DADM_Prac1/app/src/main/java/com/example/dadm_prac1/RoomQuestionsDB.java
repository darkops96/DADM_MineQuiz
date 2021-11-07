package com.example.dadm_prac1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.ArrayList;
import java.util.List;

@Database(entities = {QuestionsData.class}, version = 1, exportSchema = false)
public abstract class RoomQuestionsDB extends RoomDatabase {
    //Create database instance
    private static RoomQuestionsDB database;
    //Define database name
    private static String DATABASE_NAME = "Questions";

    //Create Dao
    public abstract QuestionsDao questionsDao();

    public synchronized static RoomQuestionsDB getInstance(final Context context){
        //Miramos si ya existe
        if(database == null){
            //Inicializamos la base de datos
            database = Room.databaseBuilder(context.getApplicationContext(), RoomQuestionsDB.class, DATABASE_NAME).allowMainThreadQueries().build();
            database.questionsDao().reset(database.questionsDao().getAll());
            //AQUI AÑADIRIAMOS LAS PREGUNTAS PARA LA BD DE PREGUNTAS
            QuestionsData question = new QuestionsData();
            //1
            question.setQuestion("¿Qué hace el Creeper?");
            question.setAnswer1("Explotar");
            question.setAnswer2("Curar");
            question.setAnswer3("Hacer Intercambios");
            question.setAnswer4("Teletransportarse");
            question.setCorrectAnswers(1000);
            question.setType(0);
            database.questionsDao().insert(question);
            //2
            question.setQuestion("¿Cuándo se creó Minecraft?");
            question.setAnswer1("2007");
            question.setAnswer2("2008");
            question.setAnswer3("2009");
            question.setAnswer4("2010");
            question.setCorrectAnswers(0010);
            question.setType(0);
            database.questionsDao().insert(question);
            //3
            question.setQuestion("¿Qué se hace con \neste bloque?");
            question.setAnswer1("Valla de piedra");
            question.setAnswer2("Barco");
            question.setAnswer3("Libro");
            question.setAnswer4("Casco de cuero");
            question.setCorrectAnswers(0100);
            question.setType(0);
            database.questionsDao().insert(question);
            //4
            question.setQuestion("¿Cómo se conoce al\ncreador del juego?");
            question.setAnswer1("Notch");
            question.setAnswer2("Miguel");
            question.setAnswer3("Marcos Gomez");
            question.setAnswer4("Steve");
            question.setCorrectAnswers(1000);
            question.setType(0);
            database.questionsDao().insert(question);
            //5
            question.setQuestion("¿Cuál de estás habilidades \nno tiene ningún mob?");
            question.setAnswer1("Volar");
            question.setAnswer2("Usar el arco");
            question.setAnswer3("Hacerte levitar");
            question.setAnswer4("Planear");
            question.setCorrectAnswers(0001);
            question.setType(0);
            database.questionsDao().insert(question);
            //6
            question.setQuestion("¿Cómo puedes saber la vida \nque tiene tu lobo sin usar ningún mod?");
            question.setAnswer1("Viendo sus orejas");
            question.setAnswer2("No se puede");
            question.setAnswer3("Viendo su cola");
            question.setAnswer4("Por el color del pelaje");
            question.setCorrectAnswers(0010);
            question.setType(0);
            database.questionsDao().insert(question);
            //7
            question.setQuestion("¿Qué lenguaje de programación \n se utilizó para crear la primera\n versión de Minecraft?");
            question.setAnswer1("Java");
            question.setAnswer2("Python");
            question.setAnswer3("Aragonés");
            question.setAnswer4("Francés");
            question.setCorrectAnswers(1000);
            question.setType(0);
            database.questionsDao().insert(question);
            //8
            question.setQuestion("¿En qué consola NO se ha lanzado Minecraft?");
            question.setAnswer1("Wii");
            question.setAnswer2("PSVita");
            question.setAnswer3("Xbox");
            question.setAnswer4("PS4");
            question.setCorrectAnswers(1000);
            question.setType(0);
            database.questionsDao().insert(question);
            //9
            question.setQuestion("¿En qué país se encuentra \n la empresa que ha desarrollado el juego?");
            question.setAnswer1("Finlandia");
            question.setAnswer2("Suecia");
            question.setAnswer3("País Vasco");
            question.setAnswer4("Perú");
            question.setCorrectAnswers(0100);
            question.setType(0);
            database.questionsDao().insert(question);
            //10
            question.setQuestion("¿Cuál es el género del juego?");
            question.setAnswer1("Sandbox");
            question.setAnswer2("FPS");
            question.setAnswer3("RPG");
            question.setAnswer4("Shoot'em up");
            question.setCorrectAnswers(1000);
            question.setType(0);
            database.questionsDao().insert(question);
            //11
            question.setQuestion("¿Qué compañía compró Mojang?");
            question.setAnswer1("Apple");
            question.setAnswer2("Sony");
            question.setAnswer3("Nestle");
            question.setAnswer4("Microsoft");
            question.setCorrectAnswers(0001);
            question.setType(0);
            database.questionsDao().insert(question);
            //12
            question.setQuestion("Un día en el juego equivale a...");
            question.setAnswer1("5 minutos en la realidad");
            question.setAnswer2("10 minutos en la realidad");
            question.setAnswer3("15 minutos en la realidad");
            question.setAnswer4("20 minutos en la realidad");
            question.setCorrectAnswers(0001);
            question.setType(0);
            database.questionsDao().insert(question);
            //13
            question.setQuestion("¿Qué hace un enderman?");
            question.setAnswer1("Teletransportarse");
            question.setAnswer2("Disparar flechas");
            question.setAnswer3("Explotar");
            question.setAnswer4("Dar leche");
            question.setCorrectAnswers(1000);
            question.setType(0);
            database.questionsDao().insert(question);
            //14
            question.setQuestion("¿Cuantos diamantes necesitas\n para hacer una pechera de diamantes?");
            question.setAnswer1("6");
            question.setAnswer2("9");
            question.setAnswer3("8");
            question.setAnswer4("7");
            question.setCorrectAnswers(0010);
            question.setType(0);
            database.questionsDao().insert(question);
            //15
            question.setQuestion("¿Qué mob da mayor cantidad de experiencia?");
            question.setAnswer1("Creeper");
            question.setAnswer2("Blaze");
            question.setAnswer3("Ghast");
            question.setAnswer4("Zombie");
            question.setCorrectAnswers(0010);
            question.setType(0);
            database.questionsDao().insert(question);

            //Preguntas con respuesta con imagen:
            //1
            question.setQuestion("¿Qué criaturas fueron\n eliminadas en 2021?");
            question.setAnswer1(Integer.toString(R.drawable.allay));
            question.setAnswer2(Integer.toString(R.drawable.glare));
            question.setAnswer3(Integer.toString(R.drawable.golemcobre));
            question.setAnswer4("");
            question.setCorrectAnswers(0110);
            question.setType(1);
            database.questionsDao().insert(question);
            //2
            question.setQuestion("¿Qué picos pueden picar\n la bedrock?");
            question.setAnswer1(Integer.toString(R.drawable.picomadera));
            question.setAnswer2(Integer.toString(R.drawable.picodiamante));
            question.setAnswer3(Integer.toString(R.drawable.picohierro));
            question.setAnswer4("");
            question.setCorrectAnswers(0000);
            question.setType(1);
            database.questionsDao().insert(question);
            //3
            question.setQuestion("¿En qué bloque crece\n la caña de azucar?");
            question.setAnswer1(Integer.toString(R.drawable.sand));
            question.setAnswer2(Integer.toString(R.drawable.soulsand));
            question.setAnswer3(Integer.toString(R.drawable.grass));
            question.setAnswer4("");
            question.setCorrectAnswers(1000);
            question.setType(1);
            database.questionsDao().insert(question);
            //4
            question.setQuestion("¿Con qué se puede\ncurar a un lobo\nen Minecraft Vanilla?");
            question.setAnswer1(Integer.toString(R.drawable.ternera));
            question.setAnswer2(Integer.toString(R.drawable.pezglobo));
            question.setAnswer3(Integer.toString(R.drawable.cerdo));
            question.setAnswer4("");
            question.setCorrectAnswers(1010);
            question.setType(1);
            database.questionsDao().insert(question);
            //5
            question.setQuestion("¿Cuál(es) aplica(n) un efecto negativo de poción?");
            question.setAnswer1(Integer.toString(R.drawable.debilidad));
            question.setAnswer2(Integer.toString(R.drawable.resistenciafuego));
            question.setAnswer3(Integer.toString(R.drawable.invisibilidad));
            question.setAnswer4("");
            question.setCorrectAnswers(1000);
            question.setType(1);
            database.questionsDao().insert(question);
            //6
            question.setQuestion("¿Con qué se puede\ncurar a un lobo\nen Minecraft Vanilla?");
            question.setAnswer1(Integer.toString(R.drawable.ternera));
            question.setAnswer2(Integer.toString(R.drawable.pezglobo));
            question.setAnswer3(Integer.toString(R.drawable.cerdo));
            question.setAnswer4("");
            question.setCorrectAnswers(1010);
            question.setType(1);
            database.questionsDao().insert(question);
            //7
            question.setQuestion("¿Con qué se puede\ncurar a un lobo\nen Minecraft Vanilla?");
            question.setAnswer1(Integer.toString(R.drawable.ternera));
            question.setAnswer2(Integer.toString(R.drawable.pezglobo));
            question.setAnswer3(Integer.toString(R.drawable.cerdo));
            question.setAnswer4("");
            question.setCorrectAnswers(1010);
            question.setType(1);
            database.questionsDao().insert(question);
            //8
            question.setQuestion("¿Con qué se puede\ncurar a un lobo\nen Minecraft Vanilla?");
            question.setAnswer1(Integer.toString(R.drawable.ternera));
            question.setAnswer2(Integer.toString(R.drawable.pezglobo));
            question.setAnswer3(Integer.toString(R.drawable.cerdo));
            question.setAnswer4("");
            question.setCorrectAnswers(1010);
            question.setType(1);
            database.questionsDao().insert(question);
            //9
            question.setQuestion("¿Con qué se puede\ncurar a un lobo\nen Minecraft Vanilla?");
            question.setAnswer1(Integer.toString(R.drawable.ternera));
            question.setAnswer2(Integer.toString(R.drawable.pezglobo));
            question.setAnswer3(Integer.toString(R.drawable.cerdo));
            question.setAnswer4("");
            question.setCorrectAnswers(1010);
            question.setType(1);
            database.questionsDao().insert(question);
            //10
            question.setQuestion("¿Con qué se puede\ncurar a un lobo\nen Minecraft Vanilla?");
            question.setAnswer1(Integer.toString(R.drawable.ternera));
            question.setAnswer2(Integer.toString(R.drawable.pezglobo));
            question.setAnswer3(Integer.toString(R.drawable.cerdo));
            question.setAnswer4("");
            question.setCorrectAnswers(1010);
            question.setType(1);
            database.questionsDao().insert(question);
            //11
            question.setQuestion("¿Con qué se puede\ncurar a un lobo\nen Minecraft Vanilla?");
            question.setAnswer1(Integer.toString(R.drawable.ternera));
            question.setAnswer2(Integer.toString(R.drawable.pezglobo));
            question.setAnswer3(Integer.toString(R.drawable.cerdo));
            question.setAnswer4("");
            question.setCorrectAnswers(1010);
            question.setType(1);
            database.questionsDao().insert(question);
            //12
            question.setQuestion("¿Con qué se puede\ncurar a un lobo\nen Minecraft Vanilla?");
            question.setAnswer1(Integer.toString(R.drawable.ternera));
            question.setAnswer2(Integer.toString(R.drawable.pezglobo));
            question.setAnswer3(Integer.toString(R.drawable.cerdo));
            question.setAnswer4("");
            question.setCorrectAnswers(1010);
            question.setType(1);
            database.questionsDao().insert(question);
            //13
            question.setQuestion("¿Con qué se puede\ncurar a un lobo\nen Minecraft Vanilla?");
            question.setAnswer1(Integer.toString(R.drawable.ternera));
            question.setAnswer2(Integer.toString(R.drawable.pezglobo));
            question.setAnswer3(Integer.toString(R.drawable.cerdo));
            question.setAnswer4("");
            question.setCorrectAnswers(1010);
            question.setType(1);
            database.questionsDao().insert(question);
            //14
            question.setQuestion("¿Con qué se puede\ncurar a un lobo\nen Minecraft Vanilla?");
            question.setAnswer1(Integer.toString(R.drawable.ternera));
            question.setAnswer2(Integer.toString(R.drawable.pezglobo));
            question.setAnswer3(Integer.toString(R.drawable.cerdo));
            question.setAnswer4("");
            question.setCorrectAnswers(1010);
            question.setType(1);
            database.questionsDao().insert(question);
            //15
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
            question.setAudio(R.raw.creeper);
            database.questionsDao().insert(question);

            question.setQuestion("¿A qué mob corresponde este sonido?");
            question.setAnswer1("Esqueleto");
            question.setAnswer2("Calamar");
            question.setAnswer3("Creeper");
            question.setAnswer4("Lobo");
            question.setCorrectAnswers(0001);
            question.setType(2);
            question.setAudio(R.raw.wolf);
            database.questionsDao().insert(question);

            question.setQuestion("¿A qué mob corresponde este sonido?");
            question.setAnswer1("Enderman");
            question.setAnswer2("Cerdo");
            question.setAnswer3("Oveja");
            question.setAnswer4("Zombie");
            question.setCorrectAnswers(0100);
            question.setType(2);
            question.setAudio(R.raw.pig);
            database.questionsDao().insert(question);

            question.setQuestion("¿A qué mob corresponde este sonido?");
            question.setAnswer1("Lobo");
            question.setAnswer2("Aldeano");
            question.setAnswer3("Creeper");
            question.setAnswer4("Zombie");
            question.setCorrectAnswers(0001);
            question.setType(2);
            question.setAudio(R.raw.zombie);
            database.questionsDao().insert(question);

            question.setQuestion("¿A qué objeto corresponde este sonido?");
            question.setAnswer1("Arco");
            question.setAnswer2("Cubo de agua");
            question.setAnswer3("Piston");
            question.setAnswer4("Placa de presión");
            question.setCorrectAnswers(0100);
            question.setType(2);
            question.setAudio(R.raw.water_bucket);
            database.questionsDao().insert(question);

            question.setQuestion("¿A qué objeto corresponde este sonido?");
            question.setAnswer1("Arco");
            question.setAnswer2("Cubo de agua");
            question.setAnswer3("Piston");
            question.setAnswer4("Placa de presión");
            question.setCorrectAnswers(0001);
            question.setType(2);
            question.setAudio(R.raw.pressure_plate);
            database.questionsDao().insert(question);

            question.setQuestion("¿A qué objeto corresponde este sonido?");
            question.setAnswer1("Arco");
            question.setAnswer2("Cubo de agua");
            question.setAnswer3("Piston");
            question.setAnswer4("Placa de presión");
            question.setCorrectAnswers(1000);
            question.setType(2);
            question.setAudio(R.raw.arrow);
            database.questionsDao().insert(question);

            question.setQuestion("¿A qué objeto corresponde este sonido?");
            question.setAnswer1("Arco");
            question.setAnswer2("Cubo de agua");
            question.setAnswer3("Piston");
            question.setAnswer4("Placa de presión");
            question.setCorrectAnswers(0010);
            question.setType(2);
            question.setAudio(R.raw.piston);
            database.questionsDao().insert(question);

            question.setQuestion("¿A qué disco pertenece este sonido?");
            question.setAnswer1("Cat");
            question.setAnswer2("Blocks");
            question.setAnswer3("13");
            question.setAnswer4("11");
            question.setCorrectAnswers(0001);
            question.setType(2);
            question.setAudio(R.raw.eleven);
            database.questionsDao().insert(question);

            question.setQuestion("¿A qué disco pertenece este sonido?");
            question.setAnswer1("Cat");
            question.setAnswer2("Blocks");
            question.setAnswer3("13");
            question.setAnswer4("11");
            question.setCorrectAnswers(1000);
            question.setType(2);
            question.setAudio(R.raw.cat);
            database.questionsDao().insert(question);

            question.setQuestion("¿A qué acción corresponde este sonido?");
            question.setAnswer1("Beber una poción");
            question.setAnswer2("Comer");
            question.setAnswer3("Romper un cristal");
            question.setAnswer4("Ponerse la armadura");
            question.setCorrectAnswers(1000);
            question.setType(2);
            question.setAudio(R.raw.potion);
            database.questionsDao().insert(question);

            question.setQuestion("¿A qué acción corresponde este sonido?");
            question.setAnswer1("Beber una poción");
            question.setAnswer2("Comer");
            question.setAnswer3("Romper un cristal");
            question.setAnswer4("Ponerse la armadura");
            question.setCorrectAnswers(0100);
            question.setType(2);
            question.setAudio(R.raw.eating);
            database.questionsDao().insert(question);

            question.setQuestion("¿A qué mob corresponde este sonido?");
            question.setAnswer1("Aldeano");
            question.setAnswer2("Enderman");
            question.setAnswer3("Esqueleto");
            question.setAnswer4("Calamar");
            question.setCorrectAnswers(0100);
            question.setType(2);
            question.setAudio(R.raw.enderman);
            database.questionsDao().insert(question);

            question.setQuestion("¿A qué mob corresponde este sonido?");
            question.setAnswer1("Aldeano");
            question.setAnswer2("Enderman");
            question.setAnswer3("Esqueleto");
            question.setAnswer4("Calamar");
            question.setCorrectAnswers(0010);
            question.setType(2);
            question.setAudio(R.raw.skeleton);
            database.questionsDao().insert(question);

            question.setQuestion("¿A qué mob corresponde este sonido?");
            question.setAnswer1("Aldeano");
            question.setAnswer2("Enderman");
            question.setAnswer3("Esqueleto");
            question.setAnswer4("Calamar");
            question.setCorrectAnswers(1000);
            question.setType(2);
            question.setAudio(R.raw.villager);
            database.questionsDao().insert(question);

        }
        return database;
    }
}
