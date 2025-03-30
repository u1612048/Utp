
package ejemplo1;

public class Docentes {
    
    //atributos
    String codigo;
    String nombres;
    String categoria;
    String estudios;
    int anhos_ant;
    double hclases;
    
    //constructor

    public Docentes(String codigo, String nombres, String categoria, String estudios, int aniosAnti, double hclases) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.categoria = categoria;
        this.estudios = estudios;
        this.anhos_ant = aniosAnti;
        this.hclases = hclases;
    }
    
//**************METODOS ADICIONALES******************
    //calculando el monto parcial
    public double PagoParcial(){
        if  (categoria.equalsIgnoreCase("Principal"))
            return hclases * 25.00;
        if (categoria.equalsIgnoreCase("Asociado"))
            return hclases * 18.00;
        if (categoria.equalsIgnoreCase("Auxiliar"))
            return hclases * 15.00;
        return 0;
    } 
    
    public double PagoBonificacion(){
        if  (categoria.equalsIgnoreCase("Principal"))
            if (estudios.equalsIgnoreCase("Doctorado"))
                return PagoParcial() * 0.20;
            if (estudios.equalsIgnoreCase("Maestria")) 
                return PagoParcial() * 0.17;
            if (estudios.equalsIgnoreCase("Ambas"))
                return PagoParcial() * 0.25;
        if (categoria.equalsIgnoreCase("Asociado"))
            if (estudios.equalsIgnoreCase("Doctorado"))
                return PagoParcial() * 0.15;
            if (estudios.equalsIgnoreCase("Maestria")) 
                return PagoParcial() * 0.10;
            if (estudios.equalsIgnoreCase("Ambas"))
                return PagoParcial() * 0.20;
        if (categoria.equalsIgnoreCase("Auxiliar"))
                if (estudios.equalsIgnoreCase("Doctorado"))
                    return PagoParcial() * 0.12;
                if (estudios.equalsIgnoreCase("Maestria")) 
                    return PagoParcial() * 0.08;
                if (estudios.equalsIgnoreCase("Ambas"))
                    return PagoParcial() * 0.17;
        return 0;        
    }
    
    public double sueldoBruto(){
        return PagoParcial() + PagoBonificacion();
    }
    
    public double descuentos(){
        if (anhos_ant < 7)
            return sueldoBruto() * 0.05;
        if (anhos_ant >= 8)
            return sueldoBruto() * 0.04;
        return 0;
    }
    
    public double SueldoNeto(){
        return sueldoBruto() - descuentos();
    }
}
