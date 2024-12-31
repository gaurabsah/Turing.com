package micro1.coding;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * You are developing a message processing system that handles communication between microservices. 
 * Messages arrive as a string and the system needs to detect and handle duplicate messages 
 * within a sliding time window. Design a message processor that maintains a fixed size queue 
 * of the most recent messages size n and can quickly determine if a new incoming message is a 
 * duplicate within this window. If a duplicate is found, return true, otherwise add the 
 * new message to the queue, removing the oldest message if the queue is full, and return false. 
 * Consider that messages are strings and the queue has a fixed size n.
 */

public class MessageProcessor {
	private final int size;
	private final Queue<String> queue;
	private final Set<String> messageSet;

	public MessageProcessor(int size) {
		this.size = size;
		this.queue = new LinkedList<>();
		this.messageSet = new HashSet<>();
	}

	public boolean processMessage(String message) {
		if (messageSet.contains(message)) {
			return true; // Duplicate found
		}

		// Add the new message
		if (queue.size() == size) {
			// Remove the oldest message
			String oldestMessage = queue.poll();
			messageSet.remove(oldestMessage);
		}

		queue.add(message);
		messageSet.add(message);

		return false; // Not a duplicate
	}

	public static void main(String[] args) {
		MessageProcessor processor = new MessageProcessor(3);

		System.out.println(processor.processMessage("hello")); // false
		System.out.println(processor.processMessage("world")); // false
		System.out.println(processor.processMessage("hello")); // true
		System.out.println(processor.processMessage("new")); // false
		System.out.println(processor.processMessage("world")); // true
		System.out.println(processor.processMessage("another")); // false
		System.out.println(processor.processMessage("new")); // true
	}
}
