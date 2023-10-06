package models.helpers;

import models.SessaoTecnica;

import java.util.ArrayList;

public class SessoesTecnicas {
    private static final SessoesTecnicas uniqueInstance = new SessoesTecnicas();

    private final ArrayList<SessaoTecnica> sessoes = new ArrayList<>();

    public static SessoesTecnicas getInstance(){
        return uniqueInstance;
    }

    public ArrayList<SessaoTecnica> getSessaoTecnicas(){
        return sessoes;
    }

    public void inserirSessaoTecnica(SessaoTecnica sessao){
        sessoes.add(sessao);
    }

    public void editarSessaoTecnica(int index, SessaoTecnica sessao){
        sessoes.set(index, sessao);
    }

    public void removerSessaoTecnica(SessaoTecnica sessao){
        sessoes.remove(sessao);
    }

    @Override
    public String toString() {
        StringBuilder sessaoTecnicaList = new StringBuilder();
        for(int i = 0; i < sessoes.size(); i++){
            sessaoTecnicaList.append(String.format("%s - %s\n", i + 1, sessoes.get(i)));
        }
        return "Minicursos[\n" + sessaoTecnicaList + "]";
    }
}
