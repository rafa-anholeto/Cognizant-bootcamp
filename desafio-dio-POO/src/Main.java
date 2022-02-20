import models.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso = new Curso();
        curso.setTitulo("Curso java");
        curso.setDescricao("descrição curso java");
        curso.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Conteudo conteudo = new Curso();
        Conteudo conteudo1 = new Mentoria();


        Mentoria m1 = new Mentoria();
        m1.setTitulo("mentoria de java");
        m1.setDescricao("descrição mentoria java");
        m1.setData(LocalDate.now());


        /*System.out.println(curso);
        System.out.println(curso2);
        System.out.println(m1);*/

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(m1);

        Dev devRafa = new Dev();
        devRafa.setNome("Rafa");
        devRafa.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos Rafa" + devRafa.getConteudosInscritos());

        devRafa.progredir();
        devRafa.progredir();
        System.out.println("-");

        System.out.println("Conteúdos inscritos Rafa" + devRafa.getConteudosInscritos());
        System.out.println("Conteúdos concluídos Rafa" + devRafa.getConteudosConcluidos());
        System.out.println("XP:" + devRafa.calcularXp());

        System.out.println("-------------------------------------------");

        Dev devJones = new Dev();
        devJones.setNome("Jones");
        devJones.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos inscritos Jones" + devJones.getConteudosInscritos());

        devJones.progredir();
        devJones.progredir();
        devJones.progredir();
        System.out.println("-");

        System.out.println("Conteúdos inscritos Jones" + devJones.getConteudosInscritos());
        System.out.println("Conteúdos concluídos Jones" + devJones.getConteudosConcluidos());
        System.out.println("XP:" + devJones.calcularXp());


    }
}
