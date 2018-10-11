package ProjetoP1POO;

/**
 * Configura os aspectos das motocicletas
 * @author Eduardo Baptista dos Santos
 */
public class Moto extends Veiculo {
    public Moto()
    {
        /** Utilizando o construtor da super classe Veiculo para inserir a velocidade e a cor da moto
         * velocidade  = 3; cor = 3 (azul)
         */
        super(3, 3);
        this.scooter = "scooter";
        this.trilha = "trilha";
        this.custom = "custom";
        this.naked = "naked";
        this.street = "street";
        /** A variável tipo recebe um número aleatório de 0 a 4 utilizando o gerador da super classe veículo */
        setTipo(super.geradorDeNumeros.nextInt(5));
    }   
    /** Método setter para modificar o tipo da moto */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /** Método getter para acessar o tipo da moto */
    public int getTipo() {
        return tipo;
    }
    
    /** Método para selecionar um tipo de moto que foi gerado aleatóriamente */
    public String tipoDeMoto(){
        switch (tipo) {
            case 0:
                return scooter;
            case 1:
                return trilha;
            case 2:
                return custom;
            case 3:
                return naked;
            default:
                return street;
        }
    }
    
    

    /** Variável de instância do tipo para a moto, tipo inteiro */
    private int tipo;
    private String scooter, trilha, custom, naked, street;
}
