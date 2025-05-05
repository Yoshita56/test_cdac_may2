package vo.hissso;

public class LoginVO
{
	private String varUserName;
	private String varPassword;
	private String varLoginSessionSalt;
	private String varIPAddress;
	private String varQuestionId;
	private String varHintAnswer;

	public String getVarUserName()
	{
		return varUserName;
	}

	public void setVarUserName(String varUserName)
	{
		this.varUserName = varUserName;
	}

	public String getVarPassword()
	{
		return varPassword;
	}

	public void setVarPassword(String varPassword)
	{
		this.varPassword = varPassword;
	}

	public String getVarLoginSessionSalt()
	{
		return varLoginSessionSalt;
	}

	public void setVarLoginSessionSalt(String varLoginSessionSalt)
	{
		this.varLoginSessionSalt = varLoginSessionSalt;
	}

	public String getVarIPAddress()
	{
		return varIPAddress;
	}

	public void setVarIPAddress(String varIPAddress)
	{
		this.varIPAddress = varIPAddress;
	}

	public String getVarQuestionId()
	{
		return varQuestionId;
	}

	public void setVarQuestionId(String varQuestionId)
	{
		this.varQuestionId = varQuestionId;
	}

	public String getVarHintAnswer()
	{
		return varHintAnswer;
	}

	public void setVarHintAnswer(String varHintAnswer)
	{
		this.varHintAnswer = varHintAnswer;
	}
}
