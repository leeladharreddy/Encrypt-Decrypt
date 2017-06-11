import java.util.*;

public class AccessControlList {
	
	HashMap<String, String> hmap = new HashMap<String, String>();

	public static void main(String args[])
	{
		AccessControlList[] file=new AccessControlList[50];		
		
		for(int i=0;i<50;i++)
		{
			file[i]=new AccessControlList();
			file[i].users(i);
		}
		System.out.println("Enter user name");
		Scanner scanner = new Scanner(System.in);
		String userName=scanner.next();
		while(true){
			System.out.println("Please Enter permission R or W or X");
			System.out.println("To login as different user enter E");
			System.out.println("enter C to close the session");
			String permission=scanner.next();
			char l=permission.charAt(0);
		
			if(l=='R'||l=='r'||l=='W'||l=='w'||l=='X'||l=='x')
				for(int i=0;i<50;i++)
				{
					file[i].userPermission(userName,permission,i);
				}
		
			}
	}
	
	public void users(int i)
	{
		i=i+1;
		if(i%4==0&&i%5!=0)
		{
			hmap.put("user1","R" );
			hmap.put("user2","R" );
			hmap.put("user3","R" );
			hmap.put("user4","R" );
			hmap.put("user5","R" );
			hmap.put("user6","R" );
			hmap.put("user7","R" );
			hmap.put("user8","R" );
			hmap.put("user9","R" );
			hmap.put("user10","R" );
		}
		else if(i%3==0&&i%2!=0&&i%5!=0&&i%7!=0)
		{
			hmap.put("user1","W" );
			hmap.put("user2","W" );
			hmap.put("user3","W" );
			hmap.put("user4","W" );
			hmap.put("user5","W" );
			hmap.put("user6","W" );
			hmap.put("user7","W" );
			hmap.put("user8","W" );
			hmap.put("user9","W" );
			hmap.put("user10","W" );
		}
		else if(i%5==0&&i%7!=0)
		{
			hmap.put("user1","X" );
			hmap.put("user2","R" );
			hmap.put("user3","W" );
			hmap.put("user4","RWX" );
			hmap.put("user5","XW" );
			hmap.put("user6","RX" );
			hmap.put("user7","WR" );
			hmap.put("user8","XR" );
			hmap.put("user9","W" );
			hmap.put("user10","X" );
		}
		else if(i%7==0)
		{
			hmap.put("user1","W" );
			hmap.put("user2","R" );
			hmap.put("user3","R" );
			hmap.put("user4","RWX" );
			hmap.put("user5","W" );
			hmap.put("user6","WX" );
			hmap.put("user7","W" );
			hmap.put("user8","X" );
			hmap.put("user9","RXW" );
			hmap.put("user10","R" );
		}
		else
		{
			hmap.put("user1","RWX" );
			hmap.put("user2","RWX" );
			hmap.put("user3","RWX" );
			hmap.put("user4","RWX" );
			hmap.put("user5","RWX" );
			hmap.put("user6","RWX" );
			hmap.put("user7","RWX" );
			hmap.put("user8","RWX" );
			hmap.put("user9","RXW" );
			hmap.put("user10","RWX" );
		}
	}

	public void userPermission(String str,String str2,int f)
	{
		for ( Map.Entry<String, String> entry : hmap.entrySet()) {
		    String key = entry.getKey();
		    String value = entry.getValue();
		    if(key.equals(str)&&value.contains(str2))
		    {
		    	System.out.println("file"+f+" "+key+" "+value);
		    }
		    
		}
	}
}