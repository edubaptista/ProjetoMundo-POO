package ProjetoP1POO;

/**
 * Classe Main, responsável por executar o projeto 
 * @author Eduardo Baptista dos Santos 
 * @version 1.0
 * RA: 22.217.017-7
 * Projeto P1 - POO
 * Ao executar o código no NetBeans, para melhor observação, redimensionar o console para o tamanho da legenda com o mapa abaixo
 */

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**Instanciando um objeto para a classe mundo e chamar os métodos necessários*/
        Mundo objetoMundo = new Mundo();
        /** Esse método está na classe mundo e é responsável por iniciar o mapa com 10 veículos de cada tipo */
        objetoMundo.iniciaMundo();
        /** Este método atualiza o mundo até não existirem veículos no mapa */
        objetoMundo.atualizaMundo();
    }
}
