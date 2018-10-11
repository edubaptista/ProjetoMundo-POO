package ProjetoP1POO;

/**
 * Configura os aspectos dos carros 
 * @author Eduardo Baptista dos Santos
 */
public class Carro extends Veiculo {
    public Carro()
    {
        /** Utilizando o construtor da super classe Veiculo para inserir a velocidade e a cor do carro
         * velocidade  = 2; cor = 2 (vermelho)
         */
        super(2, 2);
        /** A variável tipo recebe um número aleatório de 0 a 2 utilizando o gerador da super classe veículo */
        setPassageiros(super.geradorDeNumeros.nextInt(3));
    }   
    
    /** Método setter para modificar a variável passageiros */
    public void setPassageiros(int passageiros){
        this.passageiros = passageiros;
    }
    public int getPassageiros(){
        switch (passageiros) {
            /** Se passageiros for igual a 0, retorna o valor inteiro 2 para a variável passageiros
             * Se passageiros for igual a 1, retorna o valor inteiro 3 para a variável passageiros
             * Se passageiros for igual a 2, retorna o valor inteiro 3 para a variável passageiros
             */
            case 0:
                return 2;
            case 1:
                return 3;
            default:
                return 4;
        }
    }
    
    /** Variável de instância passageiros com valor inteiro */
    private int passageiros;
}
