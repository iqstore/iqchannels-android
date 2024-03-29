package ru.iqchannels.sdk.ui.widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import ru.iqchannels.sdk.R;
import ru.iqchannels.sdk.app.IQChannels;
import ru.iqchannels.sdk.schema.ChatMessage;

import java.util.Objects;

public class ReplyMessageView extends ConstraintLayout {

    private final TextView tvSenderName;
    private final TextView tvText;
    private final TextView tvFileName;
    private final ImageView imageView;
    private final ImageButton ibClose;
    private final View dividerStart;

    private final IQChannels iqchannels;

    public ReplyMessageView(Context context) {
        super(context);
        inflate(context, R.layout.layout_reply_to_message, this);
        tvSenderName = findViewById(R.id.tvSenderName);
        tvText = findViewById(R.id.tv_text);
        tvFileName = findViewById(R.id.tvFileName);
        imageView = findViewById(R.id.iv_image);
        ibClose = findViewById(R.id.ib_close);
        dividerStart = findViewById(R.id.divider_start);
        iqchannels = IQChannels.instance();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            tvSenderName.setTypeface(Typeface.create(null,700,false));
            tvText.setTypeface(Typeface.create(null,400,false));
            tvFileName.setTypeface(Typeface.create(null,400,false));
        }
    }

    public ReplyMessageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(context, R.layout.layout_reply_to_message, this);
        tvSenderName = findViewById(R.id.tvSenderName);
        tvText = findViewById(R.id.tv_text);
        tvFileName = findViewById(R.id.tvFileName);
        imageView = findViewById(R.id.iv_image);
        ibClose = findViewById(R.id.ib_close);
        dividerStart = findViewById(R.id.divider_start);
        iqchannels = IQChannels.instance();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            tvSenderName.setTypeface(Typeface.create(null,700,false));
            tvText.setTypeface(Typeface.create(null,400,false));
            tvFileName.setTypeface(Typeface.create(null,400,false));
        }
    }

    public ReplyMessageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.layout_reply_to_message, this);
        tvSenderName = findViewById(R.id.tvSenderName);
        tvText = findViewById(R.id.tv_text);
        tvFileName = findViewById(R.id.tvFileName);
        imageView = findViewById(R.id.iv_image);
        ibClose = findViewById(R.id.ib_close);
        dividerStart = findViewById(R.id.divider_start);
        iqchannels = IQChannels.instance();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            tvSenderName.setTypeface(Typeface.create(null,700,false));
            tvText.setTypeface(Typeface.create(null,400,false));
            tvFileName.setTypeface(Typeface.create(null,400,false));
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ReplyMessageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflate(context, R.layout.layout_reply_to_message, this);
        tvSenderName = findViewById(R.id.tvSenderName);
        tvText = findViewById(R.id.tv_text);
        tvFileName = findViewById(R.id.tvFileName);
        imageView = findViewById(R.id.iv_image);
        ibClose = findViewById(R.id.ib_close);
        dividerStart = findViewById(R.id.divider_start);
        iqchannels = IQChannels.instance();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            tvSenderName.setTypeface(Typeface.create(null,700,false));
            tvText.setTypeface(Typeface.create(null,400,false));
            tvFileName.setTypeface(Typeface.create(null,400,false));
        }
    }

    public void showReplyingMessage(ChatMessage message) {
        setVisibility(View.VISIBLE);
        if (message.User != null) {
            tvSenderName.setText(Objects.equals(message.User.DisplayName, "") ? message.User.Name : message.User.DisplayName);
        }
        else if (message.Client != null) {
            tvSenderName.setText(message.Client.Name);
        }

        if (message.Text != null && !message.Text.isEmpty()) {
            tvText.setVisibility(View.VISIBLE);
            tvText.setText(message.Text);
        } else {
            tvText.setVisibility(View.GONE);
        }

        if (message.File != null) {
            String imageUrl = message.File.ImagePreviewUrl;

            if (imageUrl != null) {
                tvFileName.setVisibility(View.GONE);
                imageView.setVisibility(View.VISIBLE);
                iqchannels.picasso(getContext())
                        .load(imageUrl)
                        .into(imageView);
            } else {
                imageView.setVisibility(View.GONE);
                tvFileName.setVisibility(View.VISIBLE);
                tvFileName.setText(message.File.Name);
            }
        } else {
            tvFileName.setVisibility(View.GONE);
            imageView.setVisibility(View.GONE);
        }
    }

    public void setCloseBtnVisibility(int visibility) {
        ibClose.setVisibility(visibility);
    }

    public void setVerticalDividerColor(@ColorRes int id) {
        dividerStart.setBackgroundColor(
            ContextCompat.getColor(getContext(), id)
        );
    }

    public void setTvSenderNameColor(@ColorRes int id) {
        tvSenderName.setTextColor(
            ContextCompat.getColor(getContext(), id)
        );
    }

    public void setTvTextColor(@ColorRes int id) {
        tvText.setTextColor(
            ContextCompat.getColor(getContext(), id)
        );
    }

    public void setCloseBtnClickListener(OnClickListener listener) {
        ibClose.setOnClickListener(listener);
    }

}
