package phasebook.post.photo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import phasebook.post.Post_;
import phasebook.user.PhasebookUser;

@Generated(value="Dali", date="2011-10-18T00:49:38.736+0100")
@StaticMetamodel(Photo.class)
public class Photo_ extends Post_ {
	public static volatile SingularAttribute<Photo, Integer> postId;
	public static volatile SingularAttribute<Photo, PhasebookUser> url;
	public static volatile SingularAttribute<Photo, String> label;
}
