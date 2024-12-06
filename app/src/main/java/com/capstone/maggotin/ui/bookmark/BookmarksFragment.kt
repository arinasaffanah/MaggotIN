package com.capstone.maggotin.ui.bookmark

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.capstone.maggotin.databinding.FragmentBookmarksBinding
import com.capstone.maggotin.ui.ArticleAdapter
import com.capstone.maggotin.ui.home.HomeViewModel
import com.dicoding.picodiploma.loginwithanimation.view.ViewModelFactory

class BookmarksFragment : Fragment() {

    private var _binding: FragmentBookmarksBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel by viewModels<HomeViewModel> { ViewModelFactory.getInstance(requireContext()) }
    private lateinit var bookmarkedAdapter: ArticleAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val bookmarksViewModel =
//            ViewModelProvider(this).get(BookmarksViewModel::class.java)

        _binding = FragmentBookmarksBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupRecyclerView()
        observeBookmarkedArticles()


//        val textView: TextView = binding.textBookmarks
//        bookmarksViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

//        bookmarksViewModel.bookmarkList.observe(viewLifecycleOwner) { bookmarkList ->
//            if (bookmarkList.isEmpty()) {
//                binding.emptyView.visibility = View.VISIBLE
//                binding.rvBookmarkedArticles.visibility = View.GONE
//            } else {
////                binding.emptyView.visibility = View.GONE
////                binding.rvBookmarkedArticles.visibility = View.VISIBLE
//
////                binding.rvBookmarkedArticles.adapter = BookmarkAdapter(bookmarkList)
//            }
//        }
        return root
    }

    private fun setupRecyclerView() {
        bookmarkedAdapter = ArticleAdapter { article ->
            val newBookmarkState = article.isBookmarked
            viewModel.updateBookmarkStatus(article, newBookmarkState)
            Toast.makeText(requireContext(), "Unbookmarked ${article.title}", Toast.LENGTH_SHORT).show()
            Log.d("Unbookmarked", "Article unbookmarked: ${article.title} - ${article.isBookmarked}")
        }

        binding.rvBookmarkedArticles.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = bookmarkedAdapter
        }
    }
    private fun observeBookmarkedArticles() {
        viewModel.getBookmarkedArticles().observe(viewLifecycleOwner, Observer { articles ->
            if (articles.isEmpty()) {
                binding.emptyView.visibility = View.VISIBLE
                binding.rvBookmarkedArticles.visibility = View.GONE
            } else {
                binding.emptyView.visibility = View.GONE
                binding.rvBookmarkedArticles.visibility = View.VISIBLE
                bookmarkedAdapter.submitList(articles)
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}