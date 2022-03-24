package file;

import coordinatemap.CoordinateMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileMap {
    
    // Leitura do arquivo armazenado no mapa
    public static Map <String, ArrayList<CoordinateMap>> reader(String path) throws IOException {
        
        // Instância de mapa para armazenar os atributos
        Map <String, ArrayList<CoordinateMap>> attributes3 = new HashMap<>();
        
        // Carregamento dos dados salvo na memória Buffer
        try (BufferedReader buffRead = new BufferedReader(new FileReader(path))) {
            String line = "";
            
            // Carrega as linhas do arquivo txt
            while ((line = buffRead.readLine()) != null) {
                
                // Ignorar todas as linhas que começam com H
                if (!line.startsWith("H")) {
                    
                    // Atributos do arquivo organizados e trasformados em string
                    String lineName = line.substring(1, 13).trim(); 
                    Integer pointNumber = Integer.parseInt(line.substring(19, 25).trim()); 
                    String latitude = line.substring(25, 35).trim();
                    String longitude = line.substring(35, 46).trim();
                    Double x = Double.parseDouble(line.substring(46, 55).trim());
                    Double y = Double.parseDouble(line.substring(55, 64).trim());
                    Double z = Double.parseDouble(line.substring(64, 70).trim());
                    
                    // Acessando a lista e retornando o line name
                    ArrayList <CoordinateMap> coord = attributes3.get(lineName);
                    
                    // Verificando se o line name é nulo (vázio)
                    if (coord == null) {
                        
                        // Se for nulo, uma nova instância será criada e adicionada no mapa
                        coord = new ArrayList<>();
                        attributes3.put(lineName, coord);
                        
                    }
                    
                    // Atributos adicionados na lista
                    coord.add(new CoordinateMap(lineName, pointNumber, 
                        latitude, longitude, x, y, z));
                   
                }
            
            }
            
        }
        
        return attributes3;
        
    }

}
