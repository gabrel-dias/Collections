package cursoantigo.map;

import java.util.HashMap;
import java.util.Map;

/*Honda CB500F (2023): Cerca de 25 a 30 km/l.
Yamaha MT-07 (2023): Aproximadamente 20 a 25 km/l.
Kawasaki Ninja 650 (2023): Varia entre 18 a 23 km/l.
Harley-Davidson Sportster Iron 883 (2023): Em torno de 15 a 20 km/l.
BMW S1000RR (2023): Cerca de 15 a 18 km/l.
Ducati Panigale V4 (2023): Variação de 12 a 15 km/l*/
public class ExemploMap {
    public static void main(String[] args) {
        // em maps NÃO podem haver chaves iguais, apenas os valores
        System.out.println("\nMap dos modelos de motos e seus consumos médios.\n");
        Map<String, Double> motosEconomicas = new HashMap<>() { // criação do Map com o TIPO DA CHAVE e o TIPO DO VALOR
                                                                // dentro do diamond
            {
                put("honda", 25.6); // não existe método add() em Maps, o put() faz esse papel
                put("yamnaha", 23.7);
                put("kawasaki", 21.8);
                put("harley", 17.9);
                put("bmw", 17.2);
                put("ducati", 14.1);
            }
        };
        System.out.println(motosEconomicas);
        
        System.out.println("\nSubstituindo o consumo(value) da honda(key) para 24.1\n");
        motosEconomicas.put("honda", 24.1);
        System.out.println(motosEconomicas);
        
        System.out.println("\nConferindo se a chave \"honda\" está no Map das motos", motosEconomicas.containsKey("honda"));
    }
}

class Motos { // não está sendo utilizada no momento
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
        return "Modelo = " + modelo + ", Consumo = " + consumo;
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
