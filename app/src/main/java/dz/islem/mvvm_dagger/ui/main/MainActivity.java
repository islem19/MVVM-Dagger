package dz.islem.mvvm_dagger.ui.main;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dz.islem.mvvm_dagger.R;
import dz.islem.mvvm_dagger.ui.base.BaseActivity;

public class MainActivity extends BaseActivity<MainViewModel> {

    @BindView(R.id.recycler_view_posts)
    RecyclerView recyclerView;
    @Inject
    MainAdapter mainAdapter;
    @Inject
    MainViewModelFactory mainViewModelFactory;

    @Override
    protected MainViewModel createViewModel() {
        return new ViewModelProvider(this,mainViewModelFactory).get(MainViewModel.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupRecyclerView();
        viewModel.getPosts().observe(this, posts -> mainAdapter.addPosts(posts));
        viewModel.loadPosts();

    }
    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mainAdapter);
    }

}
