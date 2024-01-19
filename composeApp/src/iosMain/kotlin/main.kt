import androidx.compose.ui.window.ComposeUIViewController
import org.shop.app.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
