package ProjetoP1POO;

/**
 * Configura os aspectos dos caminhões 
 * @author Eduardo Baptista dos Santos
 */
public class Caminhao extends Veiculo {
    public Caminhao()
    {
        /** Utilizando o construtor da super classe Veiculo para inserir a velocidade e a cor do caminhão
         * velocidade  = 1; cor = 1 (amarelo)
         */
        super(1, 1);
        /** A variável tipo recebe um número aleatório de 0 a 4 utilizando o gerador da super classe veículo */
        setCarga(super.geradorDeNumeros.nextInt(5));
    }   
    
    /** Método setter para modificar a variáel carga */
    public void setCarga(int carga){
        this.carga = carga;
    }
    
    /** Método getter para acessar a variável carga
     * No próprio método usa condições para verificar o valor da carga que é gerado aleatoriamente
     * Se carga for igual a 0, retorna o valor peso 1000kg
     * Se carga for igual a 1, retorna o valor peso 2500kg
     * Se carga for igual a 2, retorna o valor peso 3000kg
     * Se carga for igual a 3, retorna o valor peso 5000kg
     * Se carga for igual a 4, retorna o valor peso 1000kg
     * @return 
     */
    public int getCarga(){
        switch (carga) {
            case 0:
                return 1000;
            case 1:
                return 2500;
            case 2:
                return 3000;
            case 3:
                return 5000;
            default:
                return 6000;
        }
    }
    /** Cria a variável de instância carga */
    private int carga;
}
