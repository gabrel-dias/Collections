package cursoantigo.map;

//rebase
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

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
                put("yamaha", 23.7);
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
        System.out.println("\nExibindo os consumos(valores)...\n" + motosEconomicas.values()); // retornará apenas os
                                                                                               // valores do Map, sem
                                                                                               // suas chaves

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
        System.out.println(
                "O modelo " + modeloEficiente + " consome " + valorEficiente + "e é o mais eficiente de todos");

        System.out.println("Exibindo o modelo menos econômico e o seu consumo...");
        String modeloIneficiente = "";
        double valorIneficiente = Collections.min(motosEconomicas.values()); // o ineficiente será o valor MÍNIMO
                                                                             // contido no Map
        for (Entry<String, Double> entry : entries) {
            if (entry.getValue().equals(valorIneficiente)) {
                modeloIneficiente = entry.getKey();
            }
        }
        System.out.println(
                "O modelo " + modeloIneficiente + " consome " + valorIneficiente + " e é o menos eficiente de todos");

        System.out.println("\nSomando todos os consumos...");
        Collection<Double> values = motosEconomicas.values();
        double somaValues = 0;
        for (Double soma : values) {
            somaValues += soma;
        }
        System.out.println(String.format("%.2f", somaValues) + "km/l"); // utilização do String.format() é necessária,
                                                                        // para concatenar com a ultima string

        System.out.println("\nFazendo com iterator...");
        Iterator<Double> iterator = motosEconomicas.values().iterator();
        double soma = 0d;
        while (iterator.hasNext()) {
            soma += iterator.next();
            System.out.printf("%.2f ", soma);
        }

        System.out.println("\nMédia dos consumos: " + soma / motosEconomicas.size() + "km/l");

        Set<Entry<String, Double>> setRemovedora = motosEconomicas.entrySet(); // é muito melhor fazer essa remoção com
                                                                               // um iterator para evitar recursão
        for (Entry<String, Double> entry : setRemovedora) {
            if (entry.getValue().equals(17.2d)) {
                String chaveRemovida = entry.getKey();
                motosEconomicas.remove(chaveRemovida);
            }
        }
        System.out.println("\nDicionario após o modelo com consumo igual a \"17.2km/l\" ter sido removido:");
        System.out.println(motosEconomicas);
        
        System.out.println("\nDicionario com elementos na sua ordem de inserção:");
        LinkedHashMap<String, Double> motosLinkedHashMap = new LinkedHashMap<>() {
            {
                put("kawasaki", 21.8);
                put("yamaha", 23.7);
                put("honda", 25.6);
                put("harley", 17.9);
                put("bmw", 17.2);
                put("ducati", 14.1);
            }
        };
        System.out.println(motosLinkedHashMap);
        
        System.out.println("\nDicionario com elementos na sua ordem alfabética:");
        TreeMap<String, Double> motosTreeMap = new TreeMap<>(motosLinkedHashMap);
        System.out.println(motosTreeMap);
        
        System.out.println("\nApagando o dicionário...");
        motosTreeMap.clear();
        
        System.out.println("\nO dicionário está vazio? " + motosTreeMap.isEmpty());
    }
}