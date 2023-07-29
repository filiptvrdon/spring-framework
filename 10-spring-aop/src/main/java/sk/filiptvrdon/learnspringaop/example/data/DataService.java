package sk.filiptvrdon.learnspringaop.example.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService {
    
    public DataService() {
	
    }
    
    public int[] retrieveData() {
	return new int[] {11,22,33,44,55};
	// return null;
    }
}
