package com.mouhammeddbs.covid19;
import java.util.*;

/**
 * Created by Mouhammed Dbs on 13/8/2020
 */

public interface PostView
{
	public void onErrorGetPosts();
	public void onGetPosts(ArrayList<Model> array);
}
