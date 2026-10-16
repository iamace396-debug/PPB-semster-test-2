import java.util.Scanner;
import java.util.Random;
public class StreamingServicesApplication {
	public static void main(String[] args) {
			
			String[] serviceProviders = {"YouTube", "Netflix", "DSTV", "ShowMax", "PrimeTV", "SABC+"};
			String[] originCountry = {"United States", "United States", "United States", "South Africa", "United States", "South Africa"};
			
			int[] subscribers = new int[serviceProviders.length];
			int[] userRatings = new int[originCountry.length];
			
			populateSubscribers(subscribers);
			populateRatings(userRatings, serviceProviders);
			int watch = mostWatchedService(subscribers);
			sortServiceProvider(serviceProviders, originCountry, subscribers, userRatings);
			displayStreamingServices(serviceProviders, originCountry, subscribers, userRatings);
			
			
		} 
		public static void populateSubscribers(int[] subscribers) {
			
			Random random = new Random();
			
			for(int i = 0; i<subscribers.length; i++) {
				
				subscribers[i] = random.nextInt(400001) + 100000;	
			}		
		} 
		public static void populateRatings(int[] userRatings, String[] serviceProviders) {
			
			Scanner input = new Scanner(System.in);
			
			for(int i=0; i< userRatings.length; i++) {
				
				System.out.print("Enter user rating(1-5) " + serviceProviders[i] + " :");
				userRatings[i] = input.nextInt();
			}
		} 
		public static int mostWatchedService(int[] subscribers) {
			
			int highest = subscribers[0];
			int index = 0;
			
			for(int i=1; i<subscribers.length; i++) {
				
				if(subscribers[i] > highest) {
					
					highest = subscribers[i];
					index = i;
				}
			}
			return index;
		}
		public static void sortServiceProvider (String[] serviceProviders, String[] originCountry, int[] subscribers, int[] userRatings) {
			
			String tempService;
			String tempCountry;
			int tempSub;
			int tempRatings;
			
				for(int i=0; i<subscribers.length-1; i++) {
					for(int j = 0; j<subscribers.length-1; j++) {
						if(subscribers[j] > subscribers[j+1]) {
							
							tempService = serviceProviders[j];
							serviceProviders[j] = serviceProviders[j+1];
							serviceProviders[j+1] = tempService;
							
							tempCountry = originCountry[j];
							originCountry[j] = originCountry[j+1];
							originCountry[j+1] = tempCountry;
							
							tempSub = subscribers[j];
							subscribers[j] = subscribers[j+1];
							subscribers[j+1] = tempSub;
							
							tempRatings = userRatings[j];
							userRatings[j] = userRatings[j+1];
							userRatings[j+1] = tempRatings;
					}
				}
			}
		}
		
		public static void displayStreamingServices( String[] serviceProviders, String[] originCountry, int[] subscribers, int[] userRatings) {
			
			System.out.println("===================================");
			System.out.println("Service Provider\t\t Country\t\t Subscribers\t\t UserRatings");
			
			for(int i=0; i<subscribers.length;i++) {
				
				System.out.println(serviceProviders[i] + "\t\t\t\t" + originCountry[i] + "\t\t" + subscribers[i] + "\t\t\t\t" + userRatings[i]);
			}
		}
}		
	
