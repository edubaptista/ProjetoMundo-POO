package ProjetoP1POO;

/**
 *Responsável por todos os tipos de veículos 
 * @author Eduardo Baptista dos Santos
 * Esta classe gerencia os veículos com suas cores e velocidades
 */

/** Importando a classe java Random, com a finalidade de gerar números aleatórios para a simulação */
import java.util.Random;
    
public class Veiculo {
    
    /** Criando um objeto gerador de números a partir da classe Random */
    public Random geradorDeNumeros = new Random();
    
    /** Criando o construtor da classe Veiculo com os parâmetros principais e outras características
     * @param velocidade
     * @param cor */
    public Veiculo(int velocidade, int cor){
        /** Para modificar a velocidade de cada veiculo */
        setVelocidade(velocidade);
        /** Para modificar a cor de cada veiculo */
        setCor(cor);
        /** Para modificar posicao em X do veículo no mapa e gera um numero aleatório entre 0 e 29 */
        setX(geradorDeNumeros.nextInt(30));
        /** Para modificar posicao em Y do veículo no mapa e gera um numero aleatório entre 0 e 59 */
        setY(geradorDeNumeros.nextInt(60));
        /** Para modificar o estado da fábrica (tipo booleano) */
        setFabrica(true);
    }
    

    
    /** Método setter para modificar a velocidade do veículo
     * @param velocidade */
    public void setVelocidade(int velocidade){
        this.velocidade = velocidade;
    }
    /** Método setter para modificar a cor do veículo
     * @param cor */
    public void setCor(int cor){
        this.cor = cor;
    }
    /** Método setter para modificar o valor da posição em x no mapa
     * @param x */
    public void setX(int x){
        this.x = x;
    }
    /** Método setter para modificar o valor da posição em y no mapa
     * @param y */
    public void setY(int y){
        this.y = y;
    }
    /** Método setter para modificar valor da fábrica
     * @param fabrica */
    public void setFabrica(boolean fabrica){
        this.fabrica = fabrica;
    }
    
    /** Criando o método move para os veículos */
    public void move(){
        
        /** Variável direção recebe um número aleatório de 0 a 3 */
        int direcao = geradorDeNumeros.nextInt(4);
        
        /** Comando switch case para determinar as direções que os veículos seguem */
        switch (direcao) {
            /** Se a direção for igual a 0, então o veículo anda para a esquerda na sua velocidade padrão */
            case 0:
                x = x - getVelocidade();
                break;
            /** Se direção for igual a 1, então o veículo anda para direita na sua velocidade padrão */    
            case 1:
                x = x + getVelocidade();
                break;
            /** Se direção for igual a 2, então o veículo anda para cima na sua velocidade padrão */    
            case 2:
                y = y - getVelocidade();
                break;
           /** Se direção for igual a 3, então o veículo anda para baixo na sua velocidade padrão */     
            case 3:
                y = y + getVelocidade();
                break;
            default:
                break;
        }
        
        /** Caso o veículo esteja na borda 
         * Se a posição do veículo for um valor maior que 29 (após a borda direta), o veículo retorna para a borda esquerda do mapa */        
        if (x > 29)
        {
            x = x - 30;
        }
        /** Se não, se x for  um valor menor que 0 (antes a borda esquerda), o veículo retorna para a borda direita */ 
        else if (x < 0)
        {
            x = x + 30;
        }
        /** Se não, se y for um valor maior que 59 (após a borda inferior), o veículo retorna para a borda superior */
        else if (y > 59)
        {
            y = y - 60;
        }
        /** Se não, se y for um valor menor que o (após a borda superior), o veículo retorna para a borda inferior */
        else if (y < 0)
        {
            y = y + 60;
        }
    }

    /** Método getter para acessar um valor inteiro de x (posição)
     * @return  */
    public int getX(){
        return x;
    }
    /** Método getter para acessar um valor inteiro de y (posição)
     * @return  */
    public int getY(){
        return y;
    }
    public int getVelocidade(){
        return velocidade;
    }    
    /** Método getter para acessar o um valor inteiro para a cor do veículo
     * @return  */
    public int getCor(){
        return cor;
    }
    
    
    /** Declaração das variáveis de instância
     * x e y são valores inteiros para posição no mapa
     * velocidade é um valor inteiro e pode retornar valores de 1 a 3
     * cor é um valor inteiro que retorna valores de 1 a 3
     * fábrica retorna um valor booleado (verdadeiro se existir fábrica e falso se não existir fábrica)
     */
    protected int x, y, velocidade, cor;
    protected boolean fabrica;
}
