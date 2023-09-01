package tech.emotiv.cognitive.crypto

import java.io.UnsupportedEncodingException
import java.security.MessageDigest
import java.util.*
import javax.xml.bind.DatatypeConverter

/**
 * @fileName CryptoUtil
 * @author kimkihyeon
 * @since 2023/09/01
 * @version 1.0
 *
 * @Modification Information
 * @
 * @    DATE           AUTHOR          NOTE
 * @ -----------     ----------    -------------------
 * @ 2023/09/01     kimkihyeon       최초 작성
 */
open class CryptoUtil {

    open fun encrypt(str: String, pbUserKey: ByteArray?, bszIV: ByteArray?): ByteArray? {
        var enc: ByteArray? = null
        try {
            enc = KisaSeedCBC.SEED_CBC_Encrypt(pbUserKey, bszIV, str.toByteArray(Charsets.UTF_8), 0,
                str.toByteArray(Charsets.UTF_8).size)
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }
        val encoder: Base64.Encoder = Base64.getEncoder()
        val encArray: ByteArray = encoder.encode(enc)
        try {
            println(String(encArray, Charsets.UTF_8))
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }
        return encArray
    }

    open fun decrypt(str: ByteArray?, pbUserKey: ByteArray?, bszIV: ByteArray?): String? {
        val decoder: Base64.Decoder = Base64.getDecoder()
        val enc: ByteArray = decoder.decode(str)
        var result = ""
        val dec: ByteArray?
        try {
            dec = KisaSeedCBC.SEED_CBC_Decrypt(pbUserKey, bszIV, enc, 0, enc.size)
            result = String(dec!!, Charsets.UTF_8)
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }
        return result
    }

    open fun hashCode(plain: String): String {
        val digest: MessageDigest = MessageDigest.getInstance("SHA-256")
        digest.update(plain.toByteArray(Charsets.UTF_8))
        return DatatypeConverter.printHexBinary(digest.digest()).lowercase()
    }
}