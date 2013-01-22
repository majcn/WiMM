package si.fri.wimm;

public class RunWorker {

	private static SQSWorker worker;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//validate number of arguments
		if(args.length<4)
			throw new IllegalArgumentException("Four parameters should be provided: accessKey, secretKey, inputSQSQueueUrl and log SNSTopicArn");
		
		//construct the worker with parameters
		worker=new SQSWorker(args[0], args[1], args[2], args[3]);
		
		//run the worker
		worker.run();
	}

}
