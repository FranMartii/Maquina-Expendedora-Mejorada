public class MaquinaExpendedoraMejorada {
    
    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // El tipo de maquina, con premio o sin premio
    private boolean tipoMaq;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean tipoMaquina) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        tipoMaq = tipoMaquina;
        
    }

    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if(cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
        }
        else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }        
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        if(balanceClienteActual >= precioBillete) {        
            // Simula la impresion de un billete
            System.out.println("##################");
            System.out.println("# Billete de tren:");
            System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
            System.out.println("# " + precioBillete + " euros.");
            System.out.println("##################");
            System.out.println();         
    
            // Actualiza el total de dinero acumulado en la maquina
            totalDineroAcumulado = totalDineroAcumulado + precioBillete;
            // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
            balanceClienteActual = balanceClienteActual - precioBillete;
            if(tipoMaq == true){
                // Simula la impresion de un billete de regalo
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();  
            }
        }
        else {
            System.out.println("Necesitas introducir " + (precioBillete - balanceClienteActual) + " euros mas!");
                    
        }            
    }
    
    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero()
    {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    }
    
    /**
     * Vac�a el dinero de la m�quina  y devuelve la cantidad de dinero extraida.
     * Mensaje de error en caso de estar introducciendo dinero mientras si intenta 
     * extraer el dinero.
     */
    public int vaciarDineroDeLaMaquina()
    {
        if(balanceClienteActual <= 0){
        //Comprueba el balance del cliente    
        int cantidadDineroExtraida;
        cantidadDineroExtraida = totalDineroAcumulado;
        totalDineroAcumulado = 0;
        balanceClienteActual=0;
        return cantidadDineroExtraida;
    }
    else{
        //Imprime un mensaje de error por pantalla y devuelve un valor de -1
        System.out.println("No se pudo extraer el dinero acumulado en la m�quina. Operaci�n en curso. Espere a que termine la operaci�n y vuelva a intentarlo");
        return -1;
    }
}
}
