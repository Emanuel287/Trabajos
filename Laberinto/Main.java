public class Main{
    public static String caminoMasCorto="";
    public static void main(String args[]) {


        String[][] mapaA = {

                { "I", "-", "-", "X", "-", "-", "S" },
                { "X", "-", "X", "X", "X", "-", "-" },
                { "-", "-", "S", "-", "X", "X", "-" },
                { "-", "-", "X", "-", "-", "-", "-" },
                { "X", "X", "-", "-", "-", "S", "-" }
        };

        String[][] mapaB = {

                { "X", "-", "-", "X", "-", "-", "S" },
                { "-", "X", "X", "-", "X", "X", "-" },
                { "-", "I", "-", "-", "-", "X", "-" },
                { "X", "X", "X", "-", "X", "X", "-" },
                { "-", "S", "-", "-", "-", "-", "-" },
                { "-", "X", "X", "X", "-", "X", "X" },
                { "S", "-", "-", "-", "-", "-", "X" }
        };

        String[][] mapaC = {

                { "I", "-", "-", "-", "X", "X", "-", "-", "-", "S" },
                { "X", "-", "X", "X", "-", "-", "X", "X", "-", "-" },
                { "-", "-", "S", "-", "-", "-", "X", "-", "-", "X" },
                { "X", "X", "-", "X", "X", "-", "X", "X", "-", "-" },
                { "-", "-", "X", "-", "-", "-", "-", "-", "X", "-" },
                { "S", "-", "-", "X", "X", "-", "X", "X", "-", "-" },
                { "-", "-", "X", "-", "-", "-", "-", "X", "-", "S" },
                { "X", "X", "-", "-", "-", "X", "-", "-", "-", "-" }
        };

        String[][] mapaD = {
                { "I", "-", "-", "-", "-", "X", "X", "-", "-", "-", "-", "S" },
                { "X", "X", "-", "X", "X", "-", "-", "X", "X", "-", "X", "X" },
                { "-", "-", "S", "-", "-", "-", "-", "-", "X", "-", "-", "-" },
                { "X", "X", "-", "X", "X", "X", "X", "-", "X", "X", "-", "-" },
                { "-", "-", "X", "-", "-", "-", "-", "-", "X", "-", "-", "S" },
                { "S", "-", "-", "-", "X", "X", "-", "-", "-", "X", "-", "-" }
        };


        
        PosicionInicio(mapaA);
        System.out.println(caminoMasCorto);
    }


    public static void PosicionInicio(String[][] matriz){
        
        int fila=0;
        int columna=0;
        
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[0].length;j++){
                if(matriz[i][j].equals("I")){
                    
                    fila=i;
                    columna=j;
                    i=matriz.length;
                    j=matriz[0].length;
                }
            }
        }
        Mover(matriz,fila,columna,"");
    }


    public static void Mover(String[][] matriz, int fila,int columna,String camino){
        
        if(matriz[fila][columna]=="S"){
            if(caminoMasCorto=="" || camino.length()<caminoMasCorto.length()){
                caminoMasCorto=camino;
            }
        }
        String temporal=matriz[fila][columna];
        matriz[fila][columna]="V";
        if(Valido(matriz, fila-1,columna)){
            Mover(matriz,fila-1,columna,camino+'W');
        }
        if(Valido(matriz, fila,columna-1)){
            Mover(matriz,fila,columna-1,camino+'A');
        }
        if(Valido(matriz, fila,columna+1)){
            Mover(matriz,fila,columna+1,camino+'D');
        }
        if(Valido(matriz, fila+1,columna)){
            Mover(matriz,fila+1,columna,camino+'S');
        }
        matriz[fila][columna]=temporal;
        return;
    }

    public static boolean Valido(String[][] matriz, int fila,int columna){
        if(fila<0 || fila>matriz.length-1 || columna<0 || columna>matriz[0].length-1){
            return false;
        }else{

            if(matriz[fila][columna].equals("X") || matriz[fila][columna].equals("V")){
                return false;
            }
        }
        return true;
    }




}