package mms.reports.controller.hlp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.sql.rowset.WebRowSet;
import hisglobal.exceptions.HisException;
import mms.reports.vo.StoreHierarchyViewVO;

public class StoreHierarchyViewHLP {
    public static String getReturnReqDtls(StoreHierarchyViewVO vo) throws SQLException {
        StringBuilder sb = new StringBuilder();
        WebRowSet ws = vo.getWsReturnReqDtlRpt();
        Set<String> uniqueParentNode = new HashSet<>();
        Set<String> uniqueChildNode = new HashSet<>();
        Map<String, Set<String>> childNodeToSubChildNodeMap = new HashMap<>();
        int i = 0;
        try {
            if (ws != null) {
                if (ws.size() != 0) {
                    while (ws.next()) {
                        String currentChildNode = ws.getString(1);
                        String currentSubChildNode = ws.getString(6);

                        // Add SubChildNode to the map under the ChildNode
                        childNodeToSubChildNodeMap
                            .computeIfAbsent(currentChildNode, k -> new HashSet<>())
                            .add(currentSubChildNode);

                        uniqueParentNode.add(ws.getString(4));
                        uniqueChildNode.add(currentChildNode);
                    }

                    ArrayList<String> parentNode = new ArrayList<>(uniqueParentNode);
                    ArrayList<String> childNode = new ArrayList<>(uniqueChildNode);
                    
                    System.out.println("---ParentNode----" + parentNode);
                    System.out.println("---ChildNode----" + childNode);
                    System.out.println("---ChildNodeToSubChildNodeMap----" + childNodeToSubChildNodeMap);
                    
                    sb.append("<table class='table table-hover'>");
                    int requestTypeCounter = 1;
                    // Iterate through Parent Nodes
                    for (String parent : parentNode) {
                        sb.append("<tr>");
                        sb.append("<td colspan='2' class='parent-node' style='font-weight:bold'><h4>").append(parent).append("</h4></td>");
                        sb.append("</tr>");
                        boolean resetCounter = true;
                     // Iterate through Child Nodes
                        int subChildCounter = 1; // Initialize a counter for sub-child nodes
                        for (String child : childNode) {
                            sb.append("<tr>");
                            sb.append("<td class='child-node' style='padding-left: 5%;background-color: cornsilk;'><i class='fas fa-circle' style='padding: 2%;'></i>").append(" Request Type: ").append(child).append("</td>");
                            sb.append("</tr>");
                            
                                subChildCounter = 1; // Reset the counter if not already reset
                            
                            // Get Sub Child Nodes for the current Child Node
                            Set<String> subChildNodes = childNodeToSubChildNodeMap.get(child);
                            if (subChildNodes != null && !subChildNodes.isEmpty()) {
//                                boolean resetCounter = true; // Flag to reset the counter
                                for (String subChild : subChildNodes) {
                                    sb.append("<tr>");

                                    // Check if the subChild starts with "Request Type"
                                    if (subChild.startsWith("Request Type:  ")) {
                                        if (!resetCounter) {
                                            subChildCounter = 1; // Reset the counter if not already reset
                                        }
                                        resetCounter = false; // Clear the flag
                                        subChild = subChild.substring("Request Type: ".length()); // Remove "Request Type: " prefix
                                    }

                                    sb.append("<td class='sub-child-node' style='padding-left: 20%;'>")
                                      .append(subChildCounter++)
                                      .append(". ")
                                      .append(subChild)
                                      .append("</td>");
                                    sb.append("</tr>");
                                }
                            } else {
                                sb.append("<tr>");
                                sb.append("<td class='sub-child-node'>").append("Mapped Store").append("</td>");
                                sb.append("</tr>");
                            }
                        }



                    }

                    sb.append("</table>");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            new HisException("Store Wise Hierarchy View", "StoreHierarchyViewHLP.getReturnReqDtls()-->", e.getMessage());
        }
     
        sb.append("<style>");
        sb.append(".parent-node { background-color: #E9ECE7A6; }"); 
//        sb.append(".child-node { background-color: #CCFFFF; }"); 
//        sb.append(".sub-child-node { background-color: #FFCC99; }"); 
        sb.append("</style>");
        
        return sb.toString();
    }
}
