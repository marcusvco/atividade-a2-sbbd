package models.helpers;

import models.Minicurso;

import java.util.ArrayList;

public class Minicursos {
    private static final Minicursos uniqueInstance = new Minicursos();

    private final ArrayList<Minicurso> minicursos = new ArrayList<>();

    public static Minicursos getInstance(){
        return uniqueInstance;
    }

    public ArrayList<Minicurso> getMinicursos(){
        return minicursos;
    }

    public void inserirMinicurso(Minicurso minicurso){
        minicursos.add(minicurso);
    }

    public void editarMinicurso(int index, Minicurso minicurso){
        minicursos.set(index, minicurso);
    }

    public void removerMinicurso(Minicurso minicurso){
        minicursos.remove(minicurso);
    }

    @Override
    public String toString() {
        StringBuilder minicursosList = new StringBuilder();
        for(int i = 0; i < minicursos.size(); i++){
            minicursosList.append(String.format("%s - %s\n", i + 1, minicursos.get(i)));
        }
        return "Minicursos[\n" + minicursosList + "]";
    }
}
