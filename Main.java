import java.util.ArrayList;
import java.util.UUID;
import javax.swing.JOptionPane;

public class Main {

    private static ArrayList<Aluno> alunos = new ArrayList<>();
    private static ArrayList<Professor> professores = new ArrayList<>();
    private static ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public static boolean validarNome(String nome) {
        if (nome == null || nome.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Erro: O nome não pode ser nulo ou vazio.");
            return false;
        }
        return true;
    }

    public static boolean validarIdade(int idade) {
        if (idade < 0 || idade > 100) {
            JOptionPane.showMessageDialog(null, "Erro: A idade deve estar entre 0 e 100.");
            return false;
        }
        return true;
    }

    public static boolean validarCep(String cep) {
        if (!cep.matches("\\d{4}-\\d{3}")) {
            JOptionPane.showMessageDialog(null, "Erro: O CEP deve estar no formato ####-###.");
            return false;
        }
        return true;
    }

    public static boolean validarContato(String contato) {
        if (!contato.matches("\\d{6}-\\d{4}")) {
            JOptionPane.showMessageDialog(null, "Erro: O contato deve estar no formato ######-####.");
            return false;
        }
        return true;
    }

    public static boolean validarOpcao(int opcao) {
        return opcao >= 0 && opcao <= 9;
    }

    public static Aluno buscarAluno(String nome) {
        for (Aluno aluno : alunos) {
            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }
        }
        return null;
    }

    public static ArrayList<Disciplina> buscarAlunoPorId(CartaoId Id) {
        for (Aluno aluno : alunos) {
            if (aluno.getCartaoId().equals(Id)) {
                return aluno.getDisciplina();
            }
        }
        return null;
    }

    public static Professor buscarProfessor(String nome) {
        for (Professor professor : professores) {
            if (professor.getNome().equalsIgnoreCase(nome)) {
                return professor;
            }
        }
        return null;
    }

    public static Disciplina buscarDisciplina(String nome) {
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getNome().equalsIgnoreCase(nome)) {
                return disciplina;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "PROJETO REALIZADO POR: Alyson Souza Silva\nLuiza Marinho Diniz Schirmer");

        int opcao;

        while (true) {
            String menu = "|-------------------------------------|\n"
                        + "|------SISTEMA DE REGISTROS - UEA-----|\n"
                        + "\nO QUE DESEJA FAZER?\n"
                        + "1- CADASTRO\n"
                        + "2- INFORMAÇÕES\n"
                        + "3- DESEJO ME MATRICULAR/DESMATRICULAR\n"
                        + "4- VERIFICAR TURMAS\n"
                        + "5- VERIFICAR MATERIAS QUE ESTOU MATRICULADO\n"
                        + "0 - SAIR DO PROGRAMA\n";

            opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

            if (!validarOpcao(opcao)) {
                JOptionPane.showMessageDialog(null, "Por favor, digite um número entre 0 e 5.");
                continue;
            }

            switch (opcao) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Saindo do programa...");
                    return;

                case 1:
                    int num = Integer.parseInt(JOptionPane.showInputDialog("O QUE DESEJA FAZER?\n1- CADASTRO DE ALUNO\n2- CADASTRO DE PROFESSOR\n3- CADASTRO DE DISCIPLINAS\n"));

                    if (num == 1) {
                        int numeroDeAlunos = Integer.parseInt(JOptionPane.showInputDialog("Quantos Alunos Deseja Matricular?:"));

                        for (int i = 0; i < numeroDeAlunos; i++) {
                            String nome;
                            int idade;
                            String cep;
                            String contato;

                            while (true) {
                                nome = JOptionPane.showInputDialog("NOME ALUNO(A):");
                                if (validarNome(nome)) break;
                            }

                            while (true) {
                                idade = Integer.parseInt(JOptionPane.showInputDialog("DIGITE A IDADE:"));
                                if (validarIdade(idade)) break;
                            }

                            while (true) {
                                cep = JOptionPane.showInputDialog("DIGITE O CEP:");
                                if (validarCep(cep)) break;
                            }

                            while (true) {
                                contato = JOptionPane.showInputDialog("DIGITE O CONTATO:");
                                if (validarContato(contato)) break;
                            }

                            UUID uuid = UUID.randomUUID();
                            String uuidAsString = uuid.toString();
                            JOptionPane.showMessageDialog(null, "Seu UIID é: " + uuidAsString);
                            CartaoId cartaoAluno = new CartaoId(uuidAsString);
                            Aluno aluno = new Aluno(nome, idade, cep, contato, cartaoAluno);
                            alunos.add(aluno);
                            JOptionPane.showMessageDialog(null, "ALUNO ADICIONADO COM SUCESSO!\n" + aluno);
                        }

                    } else if (num == 2) {
                        int numeroDeProfessores = Integer.parseInt(JOptionPane.showInputDialog("Quantos Professores Deseja Matricular?:"));

                        for (int i = 0; i < numeroDeProfessores; i++) {
                            String nome;
                            String contato;

                            while (true) {
                                nome = JOptionPane.showInputDialog("NOME PROFESSOR(A):");
                                if (validarNome(nome)) break;
                            }

                            String formacao = JOptionPane.showInputDialog("DIGITE A FORMAÇÃO E GRAU:");

                            while (true) {
                                contato = JOptionPane.showInputDialog("DIGITE O CONTATO:");
                                if (validarContato(contato)) break;
                            }

                            Professor professor = new Professor(nome, formacao, contato);
                            professores.add(professor);
                            JOptionPane.showMessageDialog(null, "Professor adicionado com sucesso: " + professor);
                        }

                    } else if (num == 3) {
                        JOptionPane.showMessageDialog(null, "REGRAS PARA O CADRASTO DE DISCIPLINAS\n1 - É NECESSARIO TER UM PROFESSOR CADASTRADO NO SISTEMA\n2 - É NECESSARIO TER O NOME DO PROFESSOR");
                        int numeroDeDisciplinas = Integer.parseInt(JOptionPane.showInputDialog("Quantas Disciplinas Deseja Adicionar?:"));

                        for (int i = 0; i < numeroDeDisciplinas; i++) {
                            String nome;
                            String tema;
                            String nomeprofessor;
                            String horario;
                            Professor informacoesprof = null;

                            while (true) {
                                nomeprofessor = JOptionPane.showInputDialog("NOME DO PROFESSOR:");
                                informacoesprof = buscarProfessor(nomeprofessor);
                                if (informacoesprof != null) break;
                            }

                            while (true) {
                                nome = JOptionPane.showInputDialog("NOME DA DISCIPLINA:");
                                if (validarNome(nome)) break;
                            }

                            while (true) {
                                tema = JOptionPane.showInputDialog("TEMA:");
                                if (validarNome(tema)) break;
                            }

                            while (true) {
                                horario = JOptionPane.showInputDialog("HORÁRIO:");
                                if (validarNome(horario)) break;
                            }

                            Disciplina disciplina = new Disciplina(nome, tema, horario, informacoesprof);
                            disciplinas.add(disciplina);
                            informacoesprof.addDisciplina(disciplina);
                            JOptionPane.showMessageDialog(null, "A Disciplina foi adicionada com sucesso!\n" + disciplina);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "O NÚMERO QUE O USUÁRIO DIGITOU NÃO ESTÁ CORRETO.");
                    }
                    break;

                case 2:
                    int numInfo = Integer.parseInt(JOptionPane.showInputDialog("O QUE DESEJA FAZER?\n1- INFORMAÇÕES DE ALUNO\n2- INFORMAÇÕES DO PROFESSOR\n3- INFORMAÇÕES DAS DISCIPLINAS\n"));

                    if (numInfo == 1) {
                        String nome = JOptionPane.showInputDialog("Digite o nome do aluno que deseja as informações:");
                        JOptionPane.showMessageDialog(null, buscarAluno(nome));

                    } else if (numInfo == 2) {
                        String nome = JOptionPane.showInputDialog("Digite o nome do professor que deseja as informações:");
                        JOptionPane.showMessageDialog(null, buscarProfessor(nome));

                    } else if (numInfo == 3) {
                        String nome = JOptionPane.showInputDialog("Digite o nome da disciplina que deseja as informações:");
                        JOptionPane.showMessageDialog(null, buscarDisciplina(nome));

                    } else {
                        JOptionPane.showMessageDialog(null, "OPÇÃO INVÁLIDA.");
                    }
                    break;

                case 3:
                    int numMatricula = Integer.parseInt(JOptionPane.showInputDialog("O QUE DESEJA FAZER?\n1- MATRICULA\n2- DESMATRICULAR\n"));

                    if (numMatricula == 1) {
                        Aluno informacoesAluno;
                        Disciplina informacoesDisciplinas;

                        while (true) {
                            String nome = JOptionPane.showInputDialog("DIGITE O NOME DO ALUNO:");
                            informacoesAluno = buscarAluno(nome);
                            if (informacoesAluno != null) break;
                            JOptionPane.showMessageDialog(null, "O Aluno não foi encontrado. Tente novamente.");
                        }

                        while (true) {
                            String nome = JOptionPane.showInputDialog("DIGITE O NOME DA DISCIPLINA:");
                            informacoesDisciplinas = buscarDisciplina(nome);
                            if (informacoesDisciplinas != null) break;
                            JOptionPane.showMessageDialog(null, "A disciplina não foi encontrada. Tente novamente.");
                        }

                        informacoesDisciplinas.Matricular(informacoesAluno, informacoesDisciplinas);
                        informacoesAluno.addDisciplina(informacoesDisciplinas);
                        JOptionPane.showMessageDialog(null, "Matrícula realizada com sucesso.");

                    } else if (numMatricula == 2) {
                        Aluno informacoesAluno;
                        Disciplina informacoesDisciplinas;

                        while (true) {
                            String nome = JOptionPane.showInputDialog("DIGITE O NOME DO ALUNO:");
                            informacoesAluno = buscarAluno(nome);
                            if (informacoesAluno != null) break;
                            JOptionPane.showMessageDialog(null, "O Aluno não foi encontrado. Tente novamente.");
                        }

                        while (true) {
                            String nome = JOptionPane.showInputDialog("DIGITE O NOME DA DISCIPLINA:");
                            informacoesDisciplinas = buscarDisciplina(nome);
                            if (informacoesDisciplinas != null) break;
                            JOptionPane.showMessageDialog(null, "A disciplina não foi encontrada. Tente novamente.");
                        }

                        informacoesDisciplinas.Desmatricular(informacoesAluno, informacoesDisciplinas);
                        informacoesAluno.removeDisciplina(informacoesDisciplinas);
                        JOptionPane.showMessageDialog(null, "Desmatrícula realizada com sucesso.");

                    } else {
                        JOptionPane.showMessageDialog(null, "Aparentemente o número que digitou não está correto ou está nulo.");
                    }
                    break;

                case 4:
                    Disciplina turmaDisciplinas;
                    int continuar = JOptionPane.showConfirmDialog(null, "Deseja verificar uma turma?");

                    while (continuar == JOptionPane.YES_OPTION) {
                        String nome = JOptionPane.showInputDialog("DIGITE O NOME DA DISCIPLINA:");
                        turmaDisciplinas = buscarDisciplina(nome);

                        if (turmaDisciplinas == null) {
                            continuar = JOptionPane.showConfirmDialog(null, "A disciplina não foi encontrada. Deseja continuar?");
                        } else {
                            turmaDisciplinas.ImprimirLista(turmaDisciplinas);
                            continuar = JOptionPane.NO_OPTION;
                        }
                    }
                    break;

                case 5:
                    String cartaoAluno;
                    CartaoId cartaoAlunoID;
                    int continuei = JOptionPane.showConfirmDialog(null, "Deseja verificar suas disciplinas?");

                    while (continuei == JOptionPane.YES_OPTION) {
                        cartaoAluno = JOptionPane.showInputDialog("Digite o seu ID:");
                        cartaoAlunoID = new CartaoId(cartaoAluno);
                        ArrayList<Disciplina> disciplinasDoAluno = buscarAlunoPorId(cartaoAlunoID);

                        if (disciplinasDoAluno == null) {
                            continuei = JOptionPane.showConfirmDialog(null, "Aluno não encontrado. Deseja continuar?");
                        } else {
                            StringBuilder disciplinasStr = new StringBuilder("Disciplinas matriculadas:\n");
                            for (Disciplina disciplina : disciplinasDoAluno) {
                                disciplinasStr.append(disciplina.getNome()).append("\n");
                            }
                            JOptionPane.showMessageDialog(null, disciplinasStr.toString());
                            continuei = JOptionPane.NO_OPTION;
                        }
                    }
                    break;
            }
        }
    }
}
