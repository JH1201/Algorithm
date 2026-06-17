import java.util.*;

class Solution {
    
    public class User {
        String id;
        String name;
        String str;
        
        public User(String id, String name, String str) {
            this.id = id; 
            this.name = name;
            this.str = str;
        }
        
        // Getter for id
        public String getId() {
            return id;
        }

        // Setter for id
        public void setId(String id) {
            this.id = id;
        }

        // Getter for name
        public String getName() {
            return name;
        }

        // Setter for name
        public void setName(String name) {
            this.name = name;
        }

        // Getter for str
        public String getStr() {
            return str;
        }

        // Setter for str
        public void setStr(String str) {
            this.str = str;
        }
    }
    
    public String[] solution(String[] record) {
        
        ArrayList<User> answer = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        
        for(String str : record) {
            String[] arr = str.split(" ");
            
            if(arr[0].equals("Enter")) {
                
                answer.add(new User(arr[1], arr[2], "Enter"));
                map.put(arr[1], arr[2]);
                
                
            }
            
            else if(arr[0].equals("Leave")) {
                answer.add(new User(arr[1], map.get(arr[1]), "Leave"));
            }
            
            else {
                map.put(arr[1], arr[2]);
               
            }
        }
                  
        ArrayList<String> res = new ArrayList<>();
        
        for(User dto : answer) {
            
            String userNm = map.get(dto.getId());
            
            if(dto.getStr().equals("Enter")) {
                res.add(userNm + "님이 들어왔습니다.");
            }
            else if(dto.getStr().equals("Leave")) {
                res.add(userNm + "님이 나갔습니다.");
            }
        }
        
        return res.toArray(new String[0]);
    }
}