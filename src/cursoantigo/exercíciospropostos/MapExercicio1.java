package cursoantigo.exercíciospropostos;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/* Dada a população estimada de alguns estados do nordeste brasileiro, faça:
Estado = PE - população = 9.616.621
Estado = AL - população = 3.351.543
Estado = CE - população  = 9.187.103
Estado = RN - população = 3.534.265
[x] Crie um dicionário e relacione os estados e suas populações
[x] Substitua a população do estado do RN por 3.534.165
[x] Confira se o estado PB está no dicionário, caso não, adicione PB-4.039.277
[x] Exiba a população de PE
[x] Exiba todos os estados e suas populações na ordem que foram informados
[x] Exiba os estados e suas populações em ordem alfabética
[x] Exiba o estado com menor população e a sua quantidade
[x] Exiba o estado com maior população e a sua quantidade
[] Exiba a média da população desses estados
[] Remova os estados com a população menor que 4.000.000
[] Apague o dicionário de estados
[] Confira se o dicionário está vazio */

public class MapExercicio1 {
    public static void main(String[] args) {
        Map<String, Double> nordesteMap = new HashMap<>() {
            {
                put("PE", 9616621.0);
                put("AL", 3351543.0);
                put("CE", 9187103.0);
                put("RN", 3534265.0);
            }
        };
        System.out.println("Qual o valor da chave RN ? " + nordesteMap.get("RN"));

        System.out.println("Mudando para RN 3.534.165...");
        nordesteMap.replace("RN", 3534165.0);
        System.out.println("Qual o valor da chave RN ? " + nordesteMap.get("RN"));

        System.out.println("PB está no dicionário? " + nordesteMap.containsKey("PB"));
        if (nordesteMap.containsKey("PB") == false)
            nordesteMap.put("PB", 4039277.0);

        System.out.println("A população de PE é: " + nordesteMap.get("PE"));

        System.out.println("--\tOrdem aleatória\t--\n" + nordesteMap);

        Map<String, Double> nordesteLinkedMap = new LinkedHashMap<>() { // ainda não sei o porquê de precisar adicionar
                                                                        // os elementos com o put() e não o putAll() sem
                                                                        // que ele não retorne a ordem aleatória do
                                                                        // HashMap
            {
                put("PE", 9616621.0);
                put("AL", 3351543.0);
                put("CE", 9187103.0);
                put("RN", 3534265.0);
            }
        };
        System.out.println("--\tOrdem inserção\t--\n" + nordesteLinkedMap);

        Map<String, Double> nordesteTreeMap = new TreeMap<>(nordesteLinkedMap);
        System.out.println("--\tOrdem alfabética\t--\n" + nordesteTreeMap); // lembrando que a implementação TreeMap
                                                                            // utiliza um "Comparable" por padrão em
                                                                            // relação às suas chaves

        // estado com menos pessoas
        double menorPopulacao = Collections.min(nordesteTreeMap.values());
        String estadoMenosPopuloso = "";
        for (Map.Entry<String, Double> entrada : nordesteTreeMap.entrySet()) {
            if (entrada.getValue().equals(menorPopulacao)) {
                estadoMenosPopuloso = entrada.getKey();
            }
            break; // esse break aqui é um sacana, coincidentemente o primeiro elemento da entrySet
                   // é o menor valor, então após isso o loop é anulado e não verifica mais nada.
                   // O mesmo não poderá fazer a mesma coisa na forEach seguinte, pois é
                   // necessário que novas verificações sejam feitas até que o elemento de maior
                   // valor seja encontrado
        }
        System.out.println("--\tEstado com menor população\t--\n" + estadoMenosPopuloso + " = " + menorPopulacao);

        // estado com mais pessoas
        double maiorPopulacao = Collections.max(nordesteTreeMap.values());
        String estadoMaisPopuloso = "";
        for (Map.Entry<String, Double> entrada : nordesteTreeMap.entrySet()) {
            if (entrada.getValue().equals(maiorPopulacao)) {
                estadoMaisPopuloso = entrada.getKey();
            }
            // break;
        }
        System.out.println("--\tEstado com maior população\t--\n" + estadoMaisPopuloso + " = " + maiorPopulacao);
    }
}
