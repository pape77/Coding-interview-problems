<Query Kind="Expression" />

public static class Folders
{

	public static string GetBeforeOrEmpty(this string text, string stopAt = "-")
	{
		if (!String.IsNullOrWhiteSpace(text))
		{
			int charLocation = text.IndexOf(stopAt, StringComparison.Ordinal);

			if (charLocation > 0)
			{
				return text.Substring(0, charLocation);
			}
		}

		return String.Empty;
	}

	public static IEnumerable<string> GetAllFolders(string xml)
	{
		var res = new List<string>();

		string[] folderKey = { "name=\"" };
		var split = xml.Replace("name =", "name=").Split(folderKey, StringSplitOptions.RemoveEmptyEntries);
		split.Dump();
		for (int i = 1; i < split.Length; i++)
		{
			res.Add(split[i].GetBeforeOrEmpty("\""));
		}
		res.Dump();

		return res;
	}

	public static IEnumerable<string> FolderNames(string xml, char startingLetter)
	{
		var allFolders = GetAllFolders(xml);
		return allFolders.Where(f => f[0] == startingLetter);
	}
}


public static void Main(string[] args)
{
	string xml =
		"<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
		"<folder name=\"c\">" +
			"<folder name=\"program files\">" +
				"<folder name=\"uninstall information\" />" +
			"</folder>" +
			"<folder name=\"users\" />" +
		"</folder>";

	foreach (string name in Folders.FolderNames(xml, 'u'))
		Console.WriteLine(name);
}