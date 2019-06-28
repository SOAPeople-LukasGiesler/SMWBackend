/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smw.backend;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonBuilderFactory;

/**
 *  Generate JSON to publish over REST Service
 * @author giesler
 */
public class BuildJSON {
        
    public String initJSON(){
        JsonBuilderFactory factory = Json.createBuilderFactory(null);
        JsonArray array = factory.createArrayBuilder()
                .add(factory.createObjectBuilder()
                        .add("manualTitle", "Schraubzwinge bauen")
                        .add("manualInstructions", factory.createArrayBuilder()
                                .add(factory.createObjectBuilder()
                                        .add("instructionTitle", "")
                                        .add("instructionVisualization", "")
                                        .add("instructionDescription", "Lorem ipsum dolor sit amet .. ")
                                        .add("instructionItems",  factory.createArrayBuilder()
                                                .add(factory.createObjectBuilder()
                                                        .add("","")
                                                )
                                        )
                                        
                                )
                                .add(factory.createObjectBuilder()
                                        .add("instructionTitle", "Mauer bauen")
                                        .add("instructionVisualization", "")
                                        .add("instructionDescription", "Lorem ipsum dolor sit amet .. ")
                                        .add("instructionItems", factory.createArrayBuilder()
                                                .add(factory.createObjectBuilder()
                                                        .add("","")
                                                )
                                        )
                                )
                                .add(factory.createObjectBuilder()
                                        .add("instructionTitle", "Dach und Mauer zusammensetzen")
                                        .add("instructionViusalization", "")
                                        .add("instructionDescription", "Lorem ipsum dolor sit amet .. ")
                                        .add("instructionItems", factory.createArrayBuilder()
                                                .add(factory.createObjectBuilder()
                                                        .add("","")
                                                )
                                        )
                                )
                        )
                )
                .add(factory.createObjectBuilder()
                        .add("manualTitle", "Legomaennchen bauen")
                        .add("manualInstructions", factory.createArrayBuilder()
                                .add(factory.createObjectBuilder()
                                        .add("instructionTitle", "Kopf und Körper zusammensetzen")
                                        .add("instructionVisualization", "")
                                        .add("instructionDescription", "Lorem ipsum dolor sit amet .. ")
                                        .add("instructionItems", factory.createArrayBuilder()
                                                .add(factory.createObjectBuilder()
                                                        .add("","")
                                                )
                                        )
                                )
                                .add(factory.createObjectBuilder()
                                        .add("instructionTitle", "Körper und Beine zusammensetzen")
                                        .add("instructionVisualization", "")
                                        .add("instructionDescription", "Lorem ipsum dolor sit amet...")
                                        .add("instructionItems", factory.createArrayBuilder()
                                                .add(factory.createObjectBuilder()
                                                        .add("","")
                                                )
                                        )
                                )
                        )
                )
                .build();
        
        String return_array = array.toString();
        return return_array;
    }
}
