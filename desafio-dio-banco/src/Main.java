import models.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Cliente raf = new Cliente("Rafael");
        Cliente josh = new Cliente("Josh");
        Conta cc = new ContaCorrente(raf);
        cc.depositar(150.00);

        Conta poupanca = new ContaPoupanca(josh);
        cc.transferir(100.00, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();

        Banco bb = new Banco("Itaú");
        bb.getClientes().add(raf);
        bb.getClientes().add(josh);




        System.out.println(bb);

    }
}
