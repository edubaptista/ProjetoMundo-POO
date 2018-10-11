package ProjetoP1POO;
import java.util.ArrayList;

/**
 * Responsável por desenhar no console os veículos no mapa, gerenciar as colisões e atualizar o mundo
 * @author Eduardo Baptista dos Santos 
 * Esta é uma das classes principais do código, nela são construídos o mundo como se vê no console
 */
public class Mundo {
    /** Instanciando o array das motos que tem como tipo a classe Moto */
    ArrayList <Moto> arrayDeMotos = new ArrayList();
    /** Instanciando o array dos carros que tem como tipo a classe Carro */
    ArrayList <Carro> arrayDeCarros = new ArrayList();
    /** Instanciando o array dos caminhões que tem como tipo a classe Caminhão */
    ArrayList <Caminhao> arrayDeCaminhoes = new ArrayList();
    /** Instanciando o array das bicicletas que tem como tipo a classe Bicicleta */
    ArrayList <Bicicleta> arrayDeBicicletas = new ArrayList();

/**Criando o construtor da classe Mundo, inicia com os arrays zerados e com a chamada do método que atualiza o mapa */  
public Mundo(){
    addMoto = 0;
    delMoto = 0;
    addCarro = 0;
    delCarro = 0;
    addCaminhao = 0;
    delCaminhao =0;
    addBicicleta = 0;
    delBicicleta = 0;
    atualizaMapa();
}
/** Variável que implementa 1 em seu valor sempre que o método desenhaMundo opera */
int contador = 0;

/** Método que faz a inicialização do mundo, com 10 veículos de cada tipo */
public void iniciaMundo(){
    for(int i = 0; i < 10; i++){ 
        arrayDeMotos.add(new Moto());
        addMoto();
        arrayDeCarros.add(new Carro());
        addCarro();
        arrayDeCaminhoes.add(new Caminhao());
        addCaminhao();  
        arrayDeBicicletas.add(new Bicicleta());
        addBicicleta();
    }
}
/** Método que atualiza os valores de cada tipo de veículo no mapa */
public void atualizaMundo(){
    /** A condição do comando while é enquanto o array de cada veículo não estiver vazio */
    while (!arrayDeMotos.isEmpty() || !arrayDeCarros.isEmpty() || !arrayDeCaminhoes.isEmpty() 
            || !arrayDeBicicletas.isEmpty()){
        /** Enquanto o array dos veículos estiverem com pelo menos um  veículo o método atualizaMapa é chamado */
        atualizaMapa();
        /** O comando for percorre o array das motos e faz elas se movimentarem */
        for (int i = 0; i < arrayDeMotos.size(); i++){
            arrayDeMotos.get(i).move();
        }
        /** O comando for percorre o array dos carros e faz eles se movimentarem */
        for (int i = 0; i < arrayDeCarros.size(); i++){
            arrayDeCarros.get(i).move();
        }
        /** O comando for percorre o array dos caminhões e faz eles se movimentarem  */
        for (int i = 0; i < arrayDeCaminhoes.size(); i++){
            arrayDeCaminhoes.get(i).move();
        }
        /** O comando for percorre o array das bicicletas e faz eles se movimentarem a cada duas iterações
        * para isso, foi inserido um contador dentro do método desenhaMundo da classe Mundo
        * este que implementa 1 à cada vez que o método citado realiza sua operação, com isto, o método move da bicicleta
        * só é chamado quando realiza o módulo do contador por 2, se ele for zero (se o contador for par) a moto se move
        */
        for (int i = 0; i < arrayDeBicicletas.size(); i++){
            if (getContador()%2 == 0){
                arrayDeBicicletas.get(i).move();
            }
            else
                break;
            }
           
        /** Chamando o método que insere ou exclui veículos
        * insere veículos quando algum deles "passa" por uma fábrica
        * exclui veículos quando existem colisões,             
        */
        InsereOuExcluiVeiculos(arrayDeMotos, arrayDeCarros, arrayDeCaminhoes, arrayDeBicicletas);
          
        /** Desenha o mapa do mundo com os veículos inseridos e excluídos */ 
        desenhaMundo();
        
        /** Comando sleep para pausar o programa para ser possível visualizar cada atualização do código no console */
        try
        {
            Thread.sleep(400);
        }
        catch (InterruptedException ex) { }
            System.out.println();
        }
}
/** Criando o metodo para desenhar o mapa, incluindo fábricas, bordas, solo, carros, motos e caminhões */ 
public void desenhaMundo(){
    /** Contador que implementa + 1 enquanto o método desenhaMundo é executado */
    contador = contador + 1;
    
      /** Informação para o usuário de quantos veículos estão andando pelo mundo,
        * Informação para o usuário de quantos veículos foram inseridos no mundo,
        * Informação para o usuário de quantos veículos foram deletados do mundo,
        * informando a quantidade de cada tipo de veículo em relação aos tópicos acima */
    System.out.println("Andando no mundo: ");
    System.out.println("#Motos: " + this.arrayDeMotos.size() + " - #Carros: " + this.arrayDeCarros.size() + " - #Caminhões: " + this.arrayDeCaminhoes.size() + " - #Bicicletas: " + this.arrayDeBicicletas.size());
    System.out.println();
    System.out.println("Fabricados: ");
    System.out.println("#Motos: " + getAddMoto() + " - #Carros: " + getAddCarro() + " - #Caminhões: " + getAddCaminhao() + " - #Bicicletas: " + getAddBicicletas());
    System.out.println();
    System.out.println("Deletados: ");
    System.out.println("#Motos: " + getDelMoto() + " - #Carros: " + getDelCarro() + " - #Caminhões: " + getDelCaminhao() + " - #Bicicletas: " + getDelBicicletas());
    
    /** Criando a matriz do mapa com um comando "for" dentro de outro
      O primeiro for é para varre as linhas, conta até 30 (de 0 até 29) (quantidade de linhas pedida no projeto */
    for (int i = 0; i < 30; i++) {
        /** O segundo comando for varre as colunas, conta até 60 (de 0 até 59)(quantidade de colunas pedida no projeto */
        for (int j = 0; j < 60; j++) {
            /** Sequência de comandos switch/case para colorir a matriz de acordo com o numero do indice da matriz mapa */
            switch (mapaAtualizado[i][j]) {
                /** Se o conteúdo do índice for igual a 0, colore o fundo com a cor cinza (cor do solo do mapa) */
                case 0:
                    System.out.printf(ANSI_BACKGROUND_CINZA+" ");
                    break;
                /** Se o conteúdo do índice for igual a 5, colore o fundo com a cor ciano (azul claro, cor da borda do mapa) */    
                case 5:
                    System.out.printf(ANSI_BACKGROUND_CIANO+" ");
                    break;
                /** Se o conteúdo do índice for igual a 8, colore o fundo com a cor rosa (cor das fábricas no mapa) */    
                case 8:
                    System.out.printf(ANSI_BACKGROUND_ROSA+" ");
                    break;
                /** Se o conteúdo do índice for igual a 3, colore o fundo com a cor azul (cor das motos no mapa) */    
                case 3:
                    System.out.printf(ANSI_MOTO_AZUL+" ");
                    break;
                /** Se o conteúdo do índice for igual a 2, colore o fundo com a cor vermelha (cor dos carros no mapa) */    
                case 2:
                    System.out.printf(ANSI_CARRO_VERMELHO+" ");
                    break;
                /** Se o conteúdo do índice for igual a 1, colore o fundo com a cor amarela (cor dos caminhões no mapa) */    
                case 1:
                    System.out.printf(ANSI_CAMINHAO_AMARELO+" ");
                    break;
                /** Senão, se o conteúdo do índice for igual a 9, colore o fundo com a cor verde (cor das bicicletas no mapa) */    
                case 9:
                    System.out.printf(ANSI_BICICLETA_VERDE+" ");
                    break;
                default:
                    break;
            }  
      }
      /** Comando para pular linha após percorrer até 60 na linha */
      System.out.println();
    }  
}

/** Método que insere ou exclui veículos de acordo com a situação em que se encontra 
     * @param arrayDeMotos
     * @param arrayDeCarros
     * @param arrayDeCaminhoes
     * @param arrayDeBicicletas
     */
public void InsereOuExcluiVeiculos(ArrayList<Moto> arrayDeMotos, ArrayList<Carro> arrayDeCarros, 
        ArrayList<Caminhao> arrayDeCaminhoes, ArrayList<Bicicleta> arrayDeBicicletas){
    /** Declarando variáveis para receber valores inteiros para linha e coluna (posição) */
    int x, y;
    
    for (int i = 0; i < arrayDeBicicletas.size(); i++){
        /** A variável x vai receber uma posição de linha do veículo no índice i */
        x = arrayDeBicicletas.get(i).getX();   
        /** A variável y vai receber uma posição de coluna do veículo no índice i  */
        y = arrayDeBicicletas.get(i).getY();
        
        /** Se o conteúdo do índice da matriz em x e y for igual a 0 (solo) ou igual a 5 (borda), então não existe fábrica e
         * a bicicleta percorre, mas não se multiplica
         */
        switch (mapaAtualizado[x][y]) {
            case 0:
            case 5:
                arrayDeBicicletas.get(i).fabrica = false;
                mapaAtualizado[x][y] = arrayDeBicicletas.get(i).cor;
                break;
            /** Se o conteúdo do índice da matriz em x e y for igual a 8, então existe uma fábrica, sendo assim,
            * se a bicicleta passar por este índice, outra bicicleta é adicionada ao mapa numa posição aleatória
            */    
            case 8:
                if(!arrayDeBicicletas.get(i).fabrica){
                    arrayDeBicicletas.add(new Bicicleta());
                    arrayDeBicicletas.get(i).fabrica = true;
                    addBicicleta();
                }   mapaAtualizado[x][y] = arrayDeBicicletas.get(i).cor;
                break;
            /** Se o conteúdo do índice da matriz em x e y for igual a 9, então a atual bicicleta colidiu com outra bicicleta,
            * sendo assim as duas são destruídas e o contador delBicicleta recebe duas bicicletas
            */    
            case 9:
                for(int j = 0; j < i; j++){
                    if(arrayDeBicicletas.get(j).getX() == x && arrayDeBicicletas.get(j).getY() == y){
                        arrayDeBicicletas.remove(j);
                        break;
                    }
                }
                i--;
                arrayDeBicicletas.remove(i);
                i--;
                /* Variável de instância delMoto recebe duas motos que foram deletadas porque colidiram entre si */
                delBicicleta = delBicicleta + 2;
                
                /** O mapa atualizado receber os dados do mapa inicial */
                mapaAtualizado[x][y] = mapaInicial[x][y];
                break;
            default:
                break;
        }
    }
       
    /** Para percorrer todo o vetor da moto utilizando o método .size() da classe arrayList */
    for (int i = 0; i < arrayDeMotos.size(); i++){
       
        /** A variável x vai receber uma posição de linha do veículo no índice i */
        x = arrayDeMotos.get(i).getX();
        /** A variável y vai receber uma posição de coluna do veículo no índice i */
        y = arrayDeMotos.get(i).getY();
        
        /** Se o conteúdo do índice da matriz em x e y for igual a 0 (solo) ou igual a 5 (borda), então não existe fábrica e
         * a moto percorre, mas não se multiplica
         */
        switch (mapaAtualizado[x][y]) {
            case 0:
            case 5:
                arrayDeMotos.get(i).fabrica = false;
                mapaAtualizado[x][y] = arrayDeMotos.get(i).cor;
                break;
            /** Se o conteúdo do índice da matriz em x e y for igual a 8, então existe uma fábrica, sendo assim,
            * se a moto passar por este índice, outra moto é adicionada ao mapa numa posição aleatória
            */    
            case 8:
                if(!arrayDeMotos.get(i).fabrica){
                    arrayDeMotos.add(new Moto());
                    arrayDeMotos.get(i).fabrica = true;
                    addMoto();
                }   mapaAtualizado[x][y] = arrayDeMotos.get(i).cor;
                break;
            /** Se o conteúdo do índice da matriz em x e y for igual a 3, então a atual moto colidiu com outra moto,
            * sendo assim as duas são destruídas e o contador delMoto recebe duas motos
            */    
            case 3:
                for(int j = 0; j < i; j++){
                    if(arrayDeMotos.get(j).getX() == x && arrayDeMotos.get(j).getY() == y){
                        arrayDeMotos.remove(j);
                        break;
                    }
                }   
                i--;
                arrayDeMotos.remove(i);
                i--;
                /* Variável de instância delMoto recebe duas motos que foram deletadas porque colidiram entre si */
                delMoto = delMoto + 2;
                
                /** O mapa atualizado receber os dados do mapa inicial */
                mapaAtualizado[x][y] = mapaInicial[x][y];
                break;
            /** Se o conteúdo do índice da matriz em x e y for igual a 9, então a moto colidiu com uma bicicleta,
            * sendo assim a bicicleta é destruída e o contador delBicicleta recebe uma bicicleta
            */    
            case 9:
                arrayDeMotos.get(i).fabrica = false;
                for (int j = 0; j < arrayDeBicicletas.size(); j++){
                    if (arrayDeBicicletas.get(j).getX() == x && arrayDeBicicletas.get(j).getY() == y){
                        arrayDeBicicletas.remove(j);
                        delBicicleta++;
                        break;
                    }
                }   mapaAtualizado[x][y] = arrayDeMotos.get(i).cor;
                break;
            default:
                break;
        }
    }
    /** Para percorrer todo o array do carro utilizando o método .size() da classe arrayList */   
    for (int i = 0; i < arrayDeCarros.size(); i++){
        /** A variável x vai receber uma posição de linha do veículo no índice i  */
        x = arrayDeCarros.get(i).getX();
        /** A variável y vai receber uma posição de coluna do veículo no índice i  */
        y = arrayDeCarros.get(i).getY();
        
        /** Comando switch/case que seleciona o que é inserido numa posição x e y do mapa
         * se o conteúdo do índice da matriz em x e y for igual a 0 (solo) ou igual a 5 (borda), então não existe fábrica
         * e o carro percorre mas não se multiplica
         */
        switch (mapaAtualizado[x][y]) {
            case 0:
            case 5:
                arrayDeCarros.get(i).fabrica = false;
                mapaAtualizado[x][y] = arrayDeCarros.get(i).cor;
                break;
            /** Se o conteúdo do índice da matriz em x e y for igual a 8, então existe uma fábrica, sendo assim,
            * se o carro passar por este índice, outro carro é adicionado ao mapa numa posição aleatória
            */
            case 8:
                if (!arrayDeCarros.get(i).fabrica){
                    arrayDeCarros.add(new Carro());
                    arrayDeCarros.get(i).fabrica = true;
                    addCarro();
                }   mapaAtualizado[x][y] = arrayDeCarros.get(i).cor;
                break;
            /** Se o conteúdo do índice da matriz em x e y for igual a 3, então o carro colidiu com uma moto,
            * sendo assim a moto é destruída e o contador delMoto recebe uma moto
            */    
            case 3:
                arrayDeCarros.get(i).fabrica = false;
                for (int j = 0; j < arrayDeMotos.size(); j++){
                    if (arrayDeMotos.get(j).getX() == x && arrayDeMotos.get(j).getY() == y){
                        arrayDeMotos.remove(j);
                        delMoto++;
                        break;
                    }
                }   mapaAtualizado[x][y] = arrayDeCarros.get(i).cor;
                break;
            /** Se o conteúdo do indice da matriz em x  e y for igual a 2, então o carro colidiu com outro carro, 
             * sendo assim, os dois carros são destruídos e o contador delCarro recebe dois carros
             */    
            case 2:
                for (int j = 0; j < i; j++){
                    if (arrayDeCarros.get(j).getX() == x && arrayDeCarros.get(j).getY() == y){
                        arrayDeCarros.remove(j);
                        break;
                    }
                }   i--;
                arrayDeCarros.remove(i);
                i--;
                delCarro = delCarro + 2;
                mapaAtualizado[x][y] = mapaInicial[x][y];
                break;
            /** Se o conteúdo do índice da matriz em x e y for igual a 9, então o carro colidiu com uma bicicleta,
            * sendo assim a bicicleta é destruída e o contador delBicicleta recebe uma bicicleta
            */    
            case 9:
                arrayDeCarros.get(i).fabrica = false;
                for (int j = 0; j < arrayDeBicicletas.size(); j++){
                    if (arrayDeBicicletas.get(j).getX() == x && arrayDeBicicletas.get(j).getY() == y){
                        arrayDeBicicletas.remove(j);
                        delBicicleta++;
                        break;
                    }
                }   mapaAtualizado[x][y] = arrayDeCarros.get(i).cor;
                break;
            default:
                break;
        }
    }
    /** Para percorrer todo o array do caminhao utilizando o método .size() da classe arrayList */ 
    for (int i = 0; i < arrayDeCaminhoes.size(); i++) {
      /** A variável x vai receber uma posição de linha do veículo no índice i  */
      x = arrayDeCaminhoes.get(i).getX();
      /** A variável y vai receber uma posição de coluna do veículo no índice i  */
      y = arrayDeCaminhoes.get(i).getY();
        /** Comando switch/case que seleciona o que é inserido numa posição x e y do mapa
         * se o conteúdo do índice da matriz em x e y for igual a 0 (solo) ou igual a 5 (borda), então não existe fábrica
         * e o caminhão percorre mas não se multiplica
         */
        switch (mapaAtualizado[x][y]) {
            case 0:
            case 5:
                arrayDeCaminhoes.get(i).fabrica = false;
                mapaAtualizado[x][y] = arrayDeCaminhoes.get(i).cor;
                break;
            /** Se o conteúdo do índice da matriz em x e y for igual a 8, então existe uma fábrica, sendo assim,
            * se o caminhão passar por este índice, outro caminhão é adicionado ao mapa numa posição aleatória
            */    
            case 8:
                if (!arrayDeCaminhoes.get(i).fabrica) {
                arrayDeCaminhoes.add(new Caminhao());
                arrayDeCaminhoes.get(i).fabrica = true;
                addCaminhao();
                }       mapaAtualizado[x][y] = arrayDeCaminhoes.get(i).cor;
                break;
            /** Se o conteúdo do índice da matriz em x e y for igual a 3, então o caminhão colidiu com uma moto,
            * sendo assim a moto é destruída e o contador delMoto recebe uma moto
            */ 
            case 3:
                arrayDeCaminhoes.get(i).fabrica = false;
                for (int j = 0; j < arrayDeMotos.size(); j++) {
                    if (arrayDeMotos.get(j).getX() == x && arrayDeMotos.get(j).getY() == y) {
                        arrayDeMotos.remove(j);
                        delMoto++;
                        break;
                    }
                }       mapaAtualizado[x][y] = arrayDeCaminhoes.get(i).cor;
                break;
            /** Se o conteúdo do índice da matriz em x e y for igual a 2, então o caminhão colidiu com um carro,
            * sendo assim o carro é destruído e o contador delCarros recebe um carro
            */    
            case 2:
                arrayDeCaminhoes.get(i).fabrica = false;
                for (int j = 0; j < arrayDeCarros.size(); j++) {
                    if (arrayDeCarros.get(j).getX() == x && arrayDeCarros.get(j).getY() == y) {
                        arrayDeCarros.remove(j);
                        delCarro++;
                        break;
                    }
                }   mapaAtualizado[x][y] = arrayDeCaminhoes.get(i).cor;
                break;
            /** Se o conteúdo do índice da matriz em x e y for igual a 1, então o caminhão colidiu com outro caminhão,
            * sendo assim, os dois caminhões são destruídos e o contador delCaminhão recebe dois caminhões
            */     
            case 1:
                arrayDeCaminhoes.get(i).fabrica = false;
                for (int j = 0; j < i; j++) {
                    if (arrayDeCaminhoes.get(j).getX() == x && arrayDeCaminhoes.get(j).getY() == y) {
                        arrayDeCaminhoes.remove(j);
                        break;
                    }
                }   i--;
                arrayDeCaminhoes.remove(i);
                    i--;
                    delCaminhao = delCaminhao + 2;
                    mapaAtualizado[x][y] = mapaInicial[x][y];
                    break;
            /** Se o conteúdo do índice da matriz em x e y for igual a 9, então o caminhão colidiu com uma bicicleta,
            * sendo assim a bicicleta é destruída e o contador delBicicleta recebe uma bicicleta
            */    
            case 9:
                arrayDeCaminhoes.get(i).fabrica = false;
                for (int j = 0; j < arrayDeBicicletas.size(); j++){
                    if (arrayDeBicicletas.get(j).getX() == x && arrayDeBicicletas.get(j).getY() == y){
                        arrayDeBicicletas.remove(j);
                        delBicicleta++;
                        break;
                    }
                }   mapaAtualizado[x][y] = arrayDeCaminhoes.get(i).cor;
                break;
            default:
                break;
        }
    } 
}

public int getContador(){
    return contador;
}

/** Método para adicionar uma moto ao contador de adicionados */
public void addMoto(){
    addMoto++;
}
/** Método para adicionar um carro ao contador de adicionados */
public void addCarro(){
    addCarro++;
}
/** Método para adicionar um caminhão ao contador de adicionados*/
public void addCaminhao(){
    addCaminhao++;
}
/** Método para adicionar uma bicicleta ao contador de adicionados */
public void addBicicleta(){
    addBicicleta++;
}
/** Método getter para retornar um valor inteiro das motos adicionadas
     * @return  */
public int getAddMoto(){
    return addMoto;
}
/** Método getter para retornar um valor inteiro de carros adicionados
     * @return  */
public int getAddCarro(){
    return addCarro;
}
/** Método getter para retornar um valor inteiro de caminhões adicionados
     * @return  */
public int getAddCaminhao(){
    return addCaminhao;
}
/** Método getter para retornar um valor inteiro de bicicletas adicionadas
     * @return  */
public int getAddBicicletas(){
    return addBicicleta;
}
/**´Método getter para retornar um valor inteiro de motos deletadas
     * @return  */
public int getDelMoto(){
    return delMoto;
}
/** Método getter para retornar um valor inteiro de carros deletados
     * @return  */
public int getDelCarro(){
    return delCarro;
}
/** Método getter para retornar um valor inteiro de caminhões deletados
     * @return  */
public int getDelCaminhao(){
    return delCaminhao;            
}
/** Método getter para retornar um valor inteiro de bicicletas deletadas
     * @return  */
public int getDelBicicletas(){
    return delBicicleta;
}

/**Variáveis de instância que armazenam quantidades adicionadas e deletadas de veículos
 * As variáveis que levam add+(nome do veículo) armazenam veículos adicionados
 * As variáveis que levam del+(nome do veículo) armazenam veículos deletados (que colidiram em veículos superiores ou iguais)
 */  
private int addMoto, delMoto, addCarro, delCarro, addCaminhao, delCaminhao, addBicicleta, delBicicleta;    

public void atualizaMapa(){
 mapaAtualizado = new int [][]
 {
        { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
      };
}
     
  /**Declaração das variáveis estáticas para as cores de fundo, o nome das variáveis mostra a cor em que
   * o "background" aparecerá quando executar o código com base nos códigos ANSI
  */  
  public static final String ANSI_BACKGROUND_CINZA = "\033[1;47m";
  public static final String ANSI_BACKGROUND_CIANO = "\033[1;46m";
  public static final String ANSI_BACKGROUND_ROSA = "\033[1;45m";
  public static final String ANSI_MOTO_AZUL = "\033[1;44m";
  public static final String ANSI_CARRO_VERMELHO = "\033[1;41m";
  public static final String ANSI_CAMINHAO_AMARELO = "\033[1;43m";
  public static final String ANSI_BICICLETA_VERDE = "\033[1;42m";
  
  /** Criando a variável de instância do mapa atualizado */
  private int mapaAtualizado[][];
  
  /** Criando e inserindo a matriz da variável de instância mapa inicial */
  private final int mapaInicial[][] = 
  {
        { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 8, 8, 8, 8, 8, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5 },
        { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5 },
      };  
}
