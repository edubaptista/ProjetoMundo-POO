package ProjetoP1POO;

/**
 * Configura os aspectos das bicicletas 
 * @author Eduardo Baptista dos Santos
 */
public class Bicicleta extends Veiculo {
    public Bicicleta()
    {
        /** Utilizando o construtor da super classe Veiculo para inserir a velocidade e a cor da bicicleta
         * velocidade  = 4 (0.5, anda 1 a cada 2 iterações) e cor = 9 (verde)
         */
        
        super(1, 9);
        this.homem = "Homem";
        this.mulher = "mulher";
        /** A variável ciclista recebe um valor inteiro (0 ou 1) utilizando o gerador da super classe veículo */
        setCiclista(super.geradorDeNumeros.nextInt(2));
       
    }
    
    /** Método setter para modificar a variável ciclista */   
    public void setCiclista(int ciclista){
        this.ciclista = ciclista;
    }
    /** Método getter para acessar a variável ciclista */
    public int getCiclista(){
        return ciclista;
    }
    
    /** Método generoCiclista define um genero para o ciclista */ 
    public String generoCiclista(){
        /** Se ciclista for igual a 0, então o gênero é feminino
         * Se não, gênero é masculino.
         */
        if (ciclista == 0){
            return mulher;
        }
        else{
            return homem;
        }
    }
    /** Método setter para modificar a variável generoCiclista */
    public void setGeneroCiclista(String generoCiclista){
        this.generoCiclista = generoCiclista;
    }
    /** Método getter para acessar a variável generoCiclista */
    public String getGeneroCiclista(){
        return generoCiclista;
    }
    
    /** Instanciando as variáveis utilizadas */
    private int ciclista;
    private String mulher, homem, generoCiclista;
}
