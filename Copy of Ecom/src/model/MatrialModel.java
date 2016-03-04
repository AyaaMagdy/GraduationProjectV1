package model;

public class MatrialModel {
	private String TopicName;
	private String Link;

public MatrialModel() {
	// TODO Auto-generated constructor stub
}

public MatrialModel(String TopicName,String Link) {
	this.Link=Link;
	this.TopicName=TopicName;
}

public String getLink() {
	return Link;
}

public String getTopicName() {
	return TopicName;
}

public void setLink(String link) {
	Link = link;
}

 public void setTopicName(String topicName) {
	TopicName = topicName;
}

}
