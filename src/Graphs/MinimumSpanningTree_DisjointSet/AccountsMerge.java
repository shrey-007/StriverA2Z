package Graphs.MinimumSpanningTree_DisjointSet;

import java.util.*;

public class AccountsMerge {
    /**
     * Whenever we have to merge/connect similar nodes, We use Disjoint Set Data Structure
     * */

    /**
     * <h2>Concept-:</h2>
     * <p>1. Assign each name as a node.</p>
     * <p>2. Parent of each node is node itself.</p>
     * <p>3. Now traverse through all email's and insert them in hashmap to map them with their respective node().If the
     *       email at node A is already mapped with node B, so we will connect A and B node.</p>
     * <p>4. Now traverse the hashmap and suppose e1 emailId is mapped to N1 node, and if N1 ka ultimateParent N1 hi hai toh e1
     *       ko N1 index par daaldo answer list ke, else agar N1 ka ultimateParent N2 hai toh e1 ko N2 index par daalo answer list ke.</p>
     *     */

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        // find kro kitne accounts hai abhi initially
        int n=accounts.size();
        // Jitne accounts hai utni nodes banao
        DisjointSet disjointSe=new DisjointSet(n);

        // create mapping
        HashMap<String,Integer> emailToNodeMapping=new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {  // Start from 1 to skip the name
                String mail=accounts.get(i).get(j);
                if(emailToNodeMapping.containsKey(mail)){
                    // if email is already mapped then we have to connect both nodes
                    disjointSe.unionByRank(i,emailToNodeMapping.get(mail));
                }
                else{
                    emailToNodeMapping.put(mail,i);
                }
            }
        }

        // Now connected nodes ki mails ko same jagah rakho
        //It is array of arrayList. Iska ith index(mergedMails[i]) batata hai ki ith node mai konsi konsi mail hai(ArrayList<String>)
        ArrayList<String>[] mergedMails=new ArrayList[n];

        for (int i = 0; i < n; i++) {
            mergedMails[i]=new ArrayList<>();
        }

        // Traverse map put mails of connected nodes together
        for(Map.Entry<String,Integer> entry:emailToNodeMapping.entrySet()){
            String mail=entry.getKey();
            int node=entry.getValue();
            // find the ultimate parent of node
            int ultimateParent=disjointSe.findUPar(node);
            // Ab is email ko answer list ke ultimateParent ke index mai daaldo, kiuki vo usi ki email hai
            mergedMails[ultimateParent].add(mail);
        }

        // mergedMails mai kuch indexes khaali hoge coz unki mails kisi aur se merge ho gyi hai and remaining indexes ki
        // list sorted nhi hogi, hume sorted list return krni hai.Also usme name bhi daalna hai, node number nhi
        List<List<String>> ans=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // means ki ye kisi se merge ho gyi hai
            if (mergedMails[i].size()==0){continue;}
            // yaha aaya means ye merge nhi hui toh ise sort kro
            Collections.sort(mergedMails[i]);
            List<String> temp=new ArrayList<>();
            // get the name of ownwer
            String emailOwnerName=accounts.get(i).get(0);
            // add name and all his emails
            temp.add(emailOwnerName);
            temp.addAll(mergedMails[i]);
            ans.add(temp);
        }

        return ans;
    }

}
