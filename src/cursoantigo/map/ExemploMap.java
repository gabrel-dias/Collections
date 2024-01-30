package cursoantigo.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*Honda CB500F (2023): Cerca de 25 a 30 km/l.
Yamaha MT-07 (2023): Aproximadamente 20 a 25 km/l.
Kawasaki Ninja 650 (2023): Varia entre 18 a 23 km/l.
Harley-Davidson Sportster Iron 883 (2023): Em torno de 15 a 20 km/l.
BMW S1000RR (2023): Cerca de 15 a 18 km/l.
Ducati Panigale V4 (2023): Variação de 12 a 15 km/l*/
public class ExemploMap {
    public static void main(String[] args) {
        // em maps NÃO podem haver chaves iguais, apenas os valores
        System.out.println("\nCriando Map dos modelos de motos e seus consumos médios.\n");
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

        System.out.println("\nSubstituindo o consumo(value) da honda(key) para 24.1...");
        motosEconomicas.put("honda", 24.1);
        System.out.println(motosEconomicas);

        System.out.println("\nA chave \"honda\" está no Map das motos?: " + motosEconomicas.containsKey("honda"));

        System.out.println("\nQual o consumo da chave \"bmw\"? " + motosEconomicas.get("bmw")); // o método get() espera
                                                                                                // receber um objeto
                                                                                                // como parâmetro mas
                                                                                                // também aceita a chave

        System.out.println("\nExibindo apenas os modelos(chaves)...");
        Set<String> keySet = motosEconomicas.keySet(); // o método keySet() retorna um SET contendo todas as chaves do
                                                       // Map
        System.out.println(keySet);
        /*
         * Iterator<String> iterator = keySet.iterator(); //TAVA TESTANDO UMA COISA AQUI
         * while (iterator.hasNext()) {
         * String next = iterator.next();
         * if (next.equalsIgnoreCase("honda")) {
         * System.out.println(next);
         * }
         * }
         */
        System.out.println("\nExibindo os consumos(valores)...\n" + motosEconomicas.values());

        System.out.println("\nDescobrindo qual o valor mais econômico (km/l)");
        Double valorEficiente = Collections.max(motosEconomicas.values()); // no método Collections.max() é passado uma
                                                                           // Collection no parâmetro especificando o
                                                                           // que
                                                                           // se espera retornar. No caso são os valores
                                                                           // do Map, com seu valor mais alto

        System.out.println("Exibindo o modelo mais econômico com o seu respectivo consumo...");
        String modeloEficiente = "";
        Set<Entry<String, Double>> entries = motosEconomicas.entrySet(); // o método entrySet() meio que faz uma
                                                                         // conversão dos valores de um Map para Set.
                                                                         // Todos os elementos desse Set retornado serão
                                                                         // do tipo Entry

        for (Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(valorEficiente)) { // verifica todos os elementos do Set de Entry para saber se
                                                           // algum deles é igual ao valorEficiente, descoberto
                                                           // anteriormente por meio do
                                                           // Collections.max(motosEconomicas.values())
                modeloEficiente = entry.getKey();
            }
        }
        System.out.println("O modelo " + modeloEficiente + " consome " + valorEficiente);
    }
}
// adoraria fazer um commit de responsa hoje, agregando conhecimento novo, mas
// estou morrendo de tentar arrumar um problema com o notebook, então talvez o
// commit de hoje seja apenas com essa anotação mesmo pra não perder o streak

class Motos { // não está sendo utilizada no momento... e acho que nem vai ser
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