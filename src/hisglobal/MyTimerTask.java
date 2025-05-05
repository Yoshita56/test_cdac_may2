package hisglobal;

import hisglobal.utility.HisUtil;
import ipd.DAOIpd;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyTimerTask  {

	/*private final static long ONCE_PER_DAY = 1000 * 60 * 60 * 24;

	// private final static int ONE_DAY = 1;
	private final static int TWO_AM = 5;
	private final static int ZERO_MINUTES = 22;

	@Override
	public void run() {
		long currennTime = System.currentTimeMillis();
		long stopTime = currennTime + 20;// provide the 2hrs time it should
											// execute 1000*60*60*2
		while (stopTime != System.currentTimeMillis()) {
			// Do your Job Here
			DAOIpd.jobdata_populate();
			System.out.println("Start Job" + stopTime);
			System.out.println("End Job" + System.currentTimeMillis());
		}
	}

	private static Date getTomorrowMorning2AM() {

		Date date2am = new java.util.Date();
		date2am.setHours(TWO_AM);
		date2am.setMinutes(ZERO_MINUTES);

		return date2am;
	}

	// call this method from your servlet init method
	public static void startTask() {
		MyTimerTask task = new MyTimerTask();
		Timer timer = new Timer();
		// timer.schedule(task,getTomorrowMorning2AM(),ONCE_PER_DAY);// for your
		// case u need to give 1000*60*60*24

		long delay = 1000L;
		long period = 1000L * 60L * 60L * 24L;
		timer.scheduleAtFixedRate(task, delay, period);
	}

	*/
	
	
	
	
	
	
	
	static Timer timer = null;
	
	public static void startScheduler() 
	{
		System.out.println("scheduler stared");
		Calendar today = Calendar.getInstance();
		int hour24Format=Integer.parseInt(HisUtil.getParameterFromHisPathXML("JOB_DATA_SCHEDULER_TIME").replace(":","#").split("#")[0]);
		int min=Integer.parseInt(HisUtil.getParameterFromHisPathXML("JOB_DATA_SCHEDULER_TIME").replace(":","#").split("#")[1]);
		today.set(Calendar.HOUR_OF_DAY, hour24Format);
		today.set(Calendar.MINUTE, min);
		today.set(Calendar.SECOND, 0);

		timer = new Timer();
		System.out.println("today.getTime() :: " + today.getTime());
		timer.scheduleAtFixedRate(new TimerTask() 
		{
			
			@Override
			public void run() 
			{
				System.out.println("task running started @ " + new Date());
				DAOIpd.jobdata_populate();
				System.out.println("task ended @ " + new Date());
			}
		}  , today.getTime(), (TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS) / 2L ) ); // every day 2 am and 2 pm 
		
		

	}

	public static void stopScheduler() {

		if (timer != null) {

			timer.purge();
			timer.cancel();

			timer = null;

		}

	}
	
	/*public static void main(String[] args) {
		
		startScheduler();
		
		
	}*/
}
