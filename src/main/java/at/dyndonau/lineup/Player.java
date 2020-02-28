package at.dyndonau.lineup;

import java.util.Map;
import java.util.HashMap;

public class Player
{
	private String name;
	private String nickname;
	
	private Map<Integer,Size> favoredSizes = new HashMap<Integer,Size>();
	private Map<Integer,String> favoredNumbers = new HashMap<Integer,String>();
	
	public Player(String name)
	{
		this(name, null);
	}
	
	public Player(String name, String nickname)
	{
		this.setName(name);
		this.setNickname(nickname);
	}
	
	public void addFavoredSize (Integer priority, Size size)
	{
		this.favoredSizes.put(priority, size);
	}
	
	public Map<Integer,Size> getFavoredSizes()
	{
		return this.favoredSizes;
	}
	
	public void setName(String name)
	{
		this.name = name!=null ? name : null;
	}
	
	public void setNickname(String nickname)
	{
		this.nickname = nickname!=null ? nickname : null;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getNickname()
	{
		return this.nickname;
	}
}
