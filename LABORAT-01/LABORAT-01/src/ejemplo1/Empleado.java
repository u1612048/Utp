
package ejemplo1;

public class Empleado {
    
    //atributos
    String codigo;
    String nombre;
    String area;
    double sueldoBase;
    double horasExtras;
    String tip_seg;
    
    //constructor

    public Empleado(String codigo, String nombre, String area, double sueldoBase, double horasExtras, String seguro) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.area = area;
        this.sueldoBase = sueldoBase;
        this.horasExtras = horasExtras;
        this.tip_seg = seguro;
    }
    
//**************METODOS ADICIONALES******************
    //calculando el monto extra
    public double montoHExtras(){
        return sueldoBase * horasExtras / 240;
    }
    
    //calculando el monto de seguro
    public double montoSeguro(){
        if(tip_seg.equalsIgnoreCase("AFP"))
            return sueldoBase * 0.17;
        if(tip_seg.equalsIgnoreCase("SNP"))
            return sueldoBase * 0.05;
        return 0;
    }
    
    //calculando el monto de essalud
    public double montoEssalud(){
        return sueldoBase * 0.03;
    }
    
    //calculando el monto de descentos
    public double montoDescuentos(){
        return montoSeguro() + montoEssalud();
    }
    
    //calculando el monto del sueldo bruto
    public double sueldoBruto(){
        return sueldoBase + montoHExtras();
    }
    
    //calculando el sueldo neto
    public double sueldoNeto(){
        return sueldoBruto() - montoDescuentos();
    }
              
}
