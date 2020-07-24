package dz.islem.mvvm_dagger.data;

import java.util.List;

import dz.islem.mvvm_dagger.data.model.Comment;
import dz.islem.mvvm_dagger.data.model.Post;
import dz.islem.mvvm_dagger.data.network.RemoteApi;
import io.reactivex.Observable;

public class DataManager {

    private final RemoteApi remoteApi;

    public DataManager(RemoteApi remoteApi){
        this.remoteApi = remoteApi;
    }


    public Observable<List<Post>> loadPosts(){
        return remoteApi.loadPosts();
    }

    public Observable<Post> loadPostById(int id){
        return remoteApi.loadPostById(id);
    }

    public Observable<List<Comment>> loadCommentByPost(int id){
        return remoteApi.loadCommentByPost(id);
    }
}
