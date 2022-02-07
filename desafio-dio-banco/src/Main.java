import models.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cliente raf = new Cliente();
        raf.setNome("Rafael");
        Conta cc = new ContaCorrente(raf);
        cc.depositar(150.00);

        Conta poupanca = new ContaPoupanca(raf);
        cc.transferir(100.00, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        Banco bb = new Banco("Itaú");



        System.out.println(bb);

    }
}
