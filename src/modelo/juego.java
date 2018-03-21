package modelo;
/**
 *
 * @author ALVA
 */
public class juego {
    //private String arreglo[][] = new String [3][3];
    
    private int turno = 1;//1=>jugador 1 2=> jugador 2
    private String marca_1 = "X";
    private String marca_2 = "Y";
    private boolean error=false;//por si se produce algun mensaje
    private int ganador=0;// 1 cuando gane el primero, 2 cuando gane el segundo
    
    private String tablero[][] ={{"","",""},
                                 {"","",""},
                                 {"","",""}
                                };
    
    
//    public juego(){
//        for (int i = 0; i < 3; i++) {
//            for (int j = 0; j < 3; j++) {
//                tablero[i][j]="";
//            }
//        }
//        
//    }
    
    
    //matriz para almacenar los movimientos del juego
    


    //reinicia los valores y limpia el tablero
    public void Jugar_otra_vez()
    {
        for ( int i = 0 ; i < tablero.length ; i++ )
            for ( int j = 0 ; j < tablero.length ; j++)
                tablero[i][j]="";
        this.error=false;
        this.ganador=0;
        this.turno=1;

    }
    //dado una posicion y segun el turno que corresponda
    //coloca la marca "X" o "O" en el tablero
    //Salida: La marca que se coloco en la matriz
    public String set_movimiento(int posicion)
    {
        String out="";
        if(turno==1)
        {
            out = marcar(posicion , this.marca_1);
            //si no se pudo marcar => continua con su turno
            turno = 2;
            if ( gano(this.tablero, this.marca_1) )
                this.ganador=1;
            else if ( empate() )
                this.ganador=3;
        }
        else
        {
            out =  marcar(posicion , this.marca_2);
            turno = 1;
            if ( gano(this.tablero, this.marca_2) )
                this.ganador=2;
            else if ( empate() )
                this.ganador=3;
        }
        return out;
    }
    /* MARCA LA CASILLA CON EL MOVIMIENTO DEL JUGADOR, */
    private String marcar(int Posicion, String value)
    {
       String marca="";
       switch (Posicion)
       {
           case 1:marca = sub_marcar(0,0,value); break;
           case 2:marca = sub_marcar(0,1,value); break;
           case 3:marca = sub_marcar(0,2,value); break;
           case 4:marca = sub_marcar(1,0,value); break;
           case 5:marca = sub_marcar(1,1,value); break;
           case 6:marca = sub_marcar(1,2,value); break;
           case 7:marca = sub_marcar(2,0,value); break;
           case 8:marca = sub_marcar(2,1,value); break;
           case 9:marca = sub_marcar(2,2,value); break;
       }
       return marca;
    }

    //funcion privada que sigue a funcion marcar, esto para no repetir codigo
    //si al marcar en la matriz , existe algun error, coloca la bandera a TRUE
    private String sub_marcar(int x, int y, String value)
    {
        String marca="";
        this.error=false;
        if( this.tablero[x][y].equals("") ) //se puede marcar
        {
            this.tablero[x][y] = value;
            marca = value;
        }
        else//ya esta marcado
        {
            marca = this.tablero[x][y];
            this.error=true;//CASILLA YA ESTA LLENA
        }
        return marca;
    }

    public boolean get_error()
    {
        return this.error;
    }

    public String get_turno()
    {
        return (this.turno==1)? "Turno Jugador: 1":"Turno Jugador: 2";
    }

    public int ganador()
    {
        return this.ganador;
    }

    //funcion que determina quien gano la partida
    public boolean gano( String arreglo[][], String marca )
    {
        //busqueda de ganador por filas
        for ( int i = 0 ; i < arreglo.length ; i++ )
        {
            int contador=0;
            for ( int j = 0 ; j < arreglo.length ; j++)
                contador+=( arreglo[i][j].equals(marca) )?1:0;
            if( contador == 3)
                 return true;
        }
        //busqueda de ganador por columnas
        for ( int j = 0 ; j < arreglo.length ; j++ )
        {
            int contador=0;
            for ( int i = 0 ; i < arreglo.length ; i++)
                contador+=( arreglo[i][j].equals(marca) )?1:0;
            if( contador == 3)
                 return true;
        }
        //diagonales
        if(  arreglo[0][0].equals(marca) && arreglo[1][1].equals(marca) && arreglo[2][2].equals(marca) )
            return true;

        if(  arreglo[0][2].equals(marca) && arreglo[1][1].equals(marca) && arreglo[2][0].equals(marca) )
            return true;

        return false;
    }

    //Funcion que determina si se puede continuar jugando
    private boolean empate()
    {
        for ( int i = 0 ; i < tablero.length ; i++ )
           for ( int j = 0 ; j < tablero.length ; j++)
                if( tablero[i][j].equals(""))
                    return false;
        return true;
    }
}
