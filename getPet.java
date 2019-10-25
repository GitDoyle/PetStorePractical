import java.io.*;
import java.net.*;
import java.util.Scanner; 

public class getPet {
	public static void main(String args[]) throws MalformedURLException, ProtocolException, IOException {
		URL url = new URL("https://petstore.swagger.io/v2/pet/" + args[0]);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setRequestMethod("GET");
	
		connection.setRequestProperty("Content-Type", "application/json");
		connection.getResponseCode();
	
		System.out.println(connection.getResponseCode());
		System.out.println(connection.getResponseMessage());
		System.out.println(connection.getContentType());

// To store our response
StringBuilder content;

// Get the input stream of the connection
try (BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
    String line;
    content = new StringBuilder();
    while ((line = input.readLine()) != null) {
        // Append each line of the response and separate them
        content.append(line);
        content.append(System.lineSeparator());
    }
} finally {
    connection.disconnect();
}

String value = "660779600098004"; 
assert args[0] == value : "Correct pet"; 
System.out.println(value + " is not the correct pet"); 




// Output the content to the console
System.out.println(content.toString());
System.out.println(args[0]);

		}//End of main
}//End of getPet Class
