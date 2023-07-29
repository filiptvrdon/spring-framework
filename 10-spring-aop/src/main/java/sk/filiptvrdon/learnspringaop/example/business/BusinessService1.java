package sk.filiptvrdon.learnspringaop.example.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import sk.filiptvrdon.learnspringaop.example.aspect.annotations.TrackTime;
import sk.filiptvrdon.learnspringaop.example.data.DataService;

@Service
public class BusinessService1 {
    private DataService dataService1;
    
    public BusinessService1 (DataService dataService1) {
	this.dataService1 = dataService1;
	
    }
    
    @TrackTime
    public int calculateMax() throws Exception {
	int[] data = dataService1.retrieveData();
	return Arrays.stream(data).max().orElse(0);
    }
}
