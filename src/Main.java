import models.Minicurso;
import models.helpers.Minicursos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n, j;
        System.out.println("Seja bem vindo ao software de gerência SBBD!\n");

        do{
            menuPrincipal();
            n = input.nextInt();
            switch (n){
                case 1:
                    do{
                        menuMinicurso();
                        j = input.nextInt();
                        gerenciarMinicurso(j);
                    }
                    while (j != 5);
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        }while (n != 3);
        input.close();
    }

    private static void menu(String[] opcoes){
        System.out.println("Selecione uma das opções:");
        for(String opcao : opcoes){
            System.out.println(opcao);
        }
        System.out.printf("%s - Sair\n", opcoes.length + 1);
        System.out.print("Opção: ");
    }
    private static void menuPrincipal(){
        String[] opcoes = {
                "1 - Gerenciar minicurso",
                "2 - Gerenciar sessão técnica",
        };
        menu(opcoes);
    }

    private static void menuMinicurso(){
        String[] opcoes = {
                "1 - Criar minicurso",
                "2 - Editar minicurso",
                "3 - Excluir minicurso",
                "4 - Listar minicurso",
        };
        menu(opcoes);
    }

    private static void gerenciarMinicurso(int n){
        switch(n){
            case 1:
                Minicurso minicurso = criarMinicurso();
                Minicursos.getInstance().inserirMinicurso(minicurso);
                System.out.printf("Minicurso criado com sucesso! %s\n", minicurso);
                break;
            case 2:
                System.out.println("Selecione o minicurso que deseja editar:");
                System.out.println(Minicursos.getInstance());
                editarMinicurso();
                break;
            case 3:
                System.out.println("Selecione o minicurso que deseja excluir:");
                System.out.println(Minicursos.getInstance());
                excluirMinicurso();
                System.out.println("Minicurso excluido com sucesso!");
                break;
            case 4:
                System.out.println(Minicursos.getInstance());
                System.out.println("Minicursos listados com sucesso!");
                break;
            default:
                break;
        }
    }

    private static Minicurso criarMinicurso(){
        Scanner input = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");

        System.out.print("Digite a data do minicurso: ");
        LocalDate data = LocalDate.parse(input.nextLine(), dateFormat);

        System.out.print("Digite o horário de início: ");
        LocalTime horaInicio = LocalTime.parse(input.nextLine());

        System.out.print("Digite o horário de fim: ");
        LocalTime horaFim = LocalTime.parse(input.nextLine());

        return new Minicurso(data, horaInicio, horaFim);
    }

    private static void editarMinicurso(){
        Scanner input = new Scanner(System.in);
        System.out.print("Opção: ");
        int n = input.nextInt();

        if(n > 0 && n <= Minicursos.getInstance().getMinicursos().size()){
            Minicurso minicurso = criarMinicurso();
            Minicursos.getInstance().editarMinicurso(n - 1, minicurso);
            System.out.printf("Minicurso editado com sucesso! %s\n", minicurso);
        }else{
            System.out.println("Selecione um valor válido.");
        }
    }

    private static void excluirMinicurso(){
        Scanner input = new Scanner(System.in);
        System.out.print("Opção: ");
        int n = input.nextInt();

        if(n > 0 && n <= Minicursos.getInstance().getMinicursos().size()){
            Minicurso minicurso = Minicursos.getInstance().getMinicursos().get(n - 1);
            Minicursos.getInstance().removerMinicurso(minicurso);
            System.out.printf("Minicurso removido com sucesso! %s\n", minicurso);
        }else{
            System.out.println("Selecione um valor válido.");
        }
    }
}