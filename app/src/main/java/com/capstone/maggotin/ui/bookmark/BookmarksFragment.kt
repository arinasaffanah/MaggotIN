package com.capstone.maggotin.ui.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.capstone.maggotin.databinding.FragmentBookmarksBinding

class BookmarksFragment : Fragment() {

    private var _binding: FragmentBookmarksBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val bookmarksViewModel =
            ViewModelProvider(this).get(BookmarksViewModel::class.java)

        _binding = FragmentBookmarksBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textBookmarks
//        bookmarksViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        bookmarksViewModel.bookmarkList.observe(viewLifecycleOwner) { bookmarkList ->
            if (bookmarkList.isEmpty()) {
                binding.emptyView.visibility = View.VISIBLE
                binding.rvBookmarkedArticles.visibility = View.GONE
            } else {
//                binding.emptyView.visibility = View.GONE
//                binding.rvBookmarkedArticles.visibility = View.VISIBLE

//                binding.rvBookmarkedArticles.adapter = BookmarkAdapter(bookmarkList)
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}