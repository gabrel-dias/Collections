package cursoantigo.map;

import java.util.HashMap;
import java.util.Map;

public class ExemploMap {
    public static void main(String[] args) {
        // maps não podem ter chaves iguais, mas podem ter valores
        Map<String, Double> motosEconomicas = new HashMap<>(){{
            put(mo, motosEconomicas)
        }};
    }
}

class Motos {
    private String modelo;
    private double consumo;
    
    public Motos(String modelo, double consumo) {
        this.modelo = modelo;
        this.consumo = consumo;
    }
      
    public String getModelo() {
        return modelo;
    }
    public double getConsumo() {
        return consumo;
    }
    @Override
    public String toString() {
        return "modelo=" + modelo + ", consumo=" + consumo;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
        long temp;
        temp = Double.doubleToLongBits(consumo);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Motos other = (Motos) obj;
        if (modelo == null) {
            if (other.modelo != null)
                return false;
        } else if (!modelo.equals(other.modelo))
            return false;
        if (Double.doubleToLongBits(consumo) != Double.doubleToLongBits(other.consumo))
            return false;
        return true;
    }
    
    
}
